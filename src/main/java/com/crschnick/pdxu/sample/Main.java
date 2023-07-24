package com.crschnick.pdxu.sample;

import com.crschnick.pdxu.io.node.*;
import com.crschnick.pdxu.io.parser.ParseException;
import com.crschnick.pdxu.io.parser.TextFormatParser;
import com.crschnick.pdxu.io.savegame.SavegameContent;
import com.crschnick.pdxu.io.savegame.SavegameParseResult;
import com.crschnick.pdxu.io.savegame.SavegameStructure;
import com.crschnick.pdxu.io.savegame.SavegameType;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.containsAny;


// ruler config name


public class Main {
    /**
     * Generate a set of IDs of characters whose DNA you probably don't want to be ravished.
     * Uses a very brittle system to do so, but on the other hand it's easy to use and can be done from the ingame character creator...
     * <p>
     * Two types of characters and their families will be spared:
     * 1) Characters whose names match one of the names in your saved rulers directory. You might need to edit the path used in the variable `rulers_directory`. Including their family.
     * 2) Characters whose names match another living character with the name "{name}'s Cousin". It's brittle, but was used by me as a crude way to make families. Including their family.
     * <p>
     * Learning note:
     * Provides an example on how to read simple, non-save files.
     *
     * @param savegameNode A node of the save you want to modify.
     * @return A set of IDs of characters whose DNA you probably don't want to be ravished.
     * @throws IOException
     * @throws ParseException
     */
    public static Set<String> getUntouchableIds(Node savegameNode, String rulersDirectoryPath) throws IOException, ParseException {
        File rulersDirectory = new File(rulersDirectoryPath);
        File[] rulersFiles = rulersDirectory.listFiles(File::isFile);

        Set<String> untouchableNames = new HashSet<>();
        Set<String> untouchableIds = new HashSet<>();

        // ####################################
        // ## get premade character names    ##
        // ####################################
        assert rulersFiles != null;
        for(var file: rulersFiles){
            // Learning note: This is how you parse a simple non-save file.
            var node = TextFormatParser.ck3().parse(Path.of(file.toURI()));
            untouchableNames.add(node.getNodeForKey("ruler").getNodeForKey("config").getNodeForKey("name").toString());
        }

        // ####################################
        // ## get characters ##
        // ####################################
        var livingPeopleKeys = new ArrayList<String>();
        var charactersWithCousinsNames = new TreeSet<String>();

        var living = savegameNode.getNodeForKey("living");
        // Extract keys
        living.forEach((nodeKey, node) -> {
            livingPeopleKeys.add(nodeKey);
        });

        // Get initial list of characters who have "cousins"
        for (var nodeKey : livingPeopleKeys) {
            var character = living.getNodeForKey(nodeKey);
            var name = character.getNodeForKey("first_name").getString();

            if(name.contains("'s Cousin")){
                var uncousin = name.substring(0,name.length() -"'s Cousin".length());
                charactersWithCousinsNames.add(uncousin);
            }
        }

        // ####################################
        // ## Mark untouchable ##
        // ####################################
        for (var nodeKey : livingPeopleKeys) {

            var character = living.getNodeForKey(nodeKey);
            var name = character.getNodeForKey("first_name").getString();

            if (name.contains("'s Cousin") || charactersWithCousinsNames.contains(name) || untouchableNames.contains(name)) {
                // Mark character as untouchable
                untouchableIds.add(nodeKey);

                // Mark character's family as untouchable
                if (character.hasKey("family_data")) {
                    var familyNode = character.getNodeForKey("family_data");
                    // Mark character's spouse as untouchable
                    if(familyNode.hasKey("primary_spouse"))
                    {
                        var primarySpouseId = familyNode.getNodeForKey("primary_spouse");
                        untouchableIds.add(primarySpouseId.getString());
                    }
                    // Mark character's children as untouchable
                    if(familyNode.hasKey("child")) {
                        var children = familyNode.getNodeForKey("child");
                        for (var childId : children.getNodeArray()) {
                            untouchableIds.add(childId.getString());
                        }
                    }

                }
            }
        }
        return untouchableIds;
    }

    /**
     * Returns a modified savegameNode with randomized DNA for everyone except for characters you don't want randomized.
     * <p>
     * Learning note:
     * Provides an example on how to create new entries in nested array nodes.
     * <p>
     * Side effects:
     * Outputs a new file to outputFile
     *
     * @param savegameNode   A node of the save you want to modify.
     * @param untouchableIds A list of ids of characters whose dna will not be randomized
     * @return Returns a modified savegameNode.
     */
    public static Node randomizeDna(Node savegameNode, Set<String> untouchableIds) {
        var living = savegameNode.getNodeForKey("living");
        // Extract keys
        var livingPeopleKeys = new ArrayList<String>();
        living.forEach((nodeKey, node) -> {
            livingPeopleKeys.add(nodeKey);
        });

        // Generate enough random DNA beforehand
        Queue<String> randomDnaQueue = new LinkedList<>();
        for(int i=0; i <livingPeopleKeys.size(); i++){
            randomDnaQueue.offer(DNA.CreateRandomDNA());
        }

        // Learning note:  Some characters may not have a DNA key. This array will be used to create
        var newLivingCharacters = new ArrayList<ArrayNode>();

        for (var nodeKey : livingPeopleKeys) {
            var characterNode = living.getNodeForKey(nodeKey);
            var name = characterNode.getNodeForKey("first_name").getString();

            // If the character's ID is not protected, ruin their DNA... they deserve it.
            if (!untouchableIds.contains(nodeKey)){
                System.out.println("mutilating " + nodeKey + ", name: " + name);
                var randomDnaString = Objects.requireNonNull(randomDnaQueue.poll());
                var randomizedDnaArrayNode = ArrayNode.singleKeyNode("dna", new ValueNode(randomDnaString, true));

                if (characterNode.hasKey("dna")) {
                    var randomizedDna = new ValueNode(randomDnaString, true);;
                    var dnaNode = characterNode.getNodeForKey("dna");
                    // Learning note: This is how to update the value of an existing node.
                    dnaNode.getValueNode().set(randomizedDna);
                }
                else{
                    // Learning note:  If a character does not have the DNA key, create a brand new node that is an amgalam of the old node and a new DNA key.
                    // Learning note: beingIndex=0 and length=0 mean "just place it". In advance cases, the index of the node actually matters, for example if DNA had to come after the key "X" then beinIndex would have to come after "X"'s index.
                    characterNode = characterNode.getArrayNode().replacePart(randomizedDnaArrayNode, 0, 0);
                }
            }
            // Learning note:  Add the potentially completely new character node to the new "living" node. This is the most performative way to do this!
            newLivingCharacters.add(ArrayNode.singleKeyNode(nodeKey, characterNode));
        }
        // Learning note:  Update the new node
        savegameNode = savegameNode.getArrayNode().replaceKey("living", new LinkedArrayNode(newLivingCharacters));

        return savegameNode;
    }


    /**
     * Verify that there's no dupes or unmatched cousins. Probably not very interesting for learning how to use pdxu
     *
     * @param charactersWithCousinsName
     * @param landedCharacterNames
     * @param landedCharactersByName
     */
    public static void findDupeCousins(TreeSet<String> charactersWithCousinsName, ArrayList<String> landedCharacterNames, HashMap<String, List<Tuple<Node,Optional<Node>>>> landedCharactersByName) {
        var dupeCharacters = new HashMap<String, List<Tuple<Node,Optional<Node>>>>();
        var unmatchedCousinNames = new ArrayList<String>();
        for (var name : charactersWithCousinsName) {
            if (Collections.frequency(landedCharacterNames, name) > 1) {
                dupeCharacters.put(name, new ArrayList<>());
                dupeCharacters.get(name).addAll(landedCharactersByName.get(name));
                continue;
            }
            if (Collections.frequency(landedCharacterNames, name) < 1) {
                unmatchedCousinNames.add(name);
            }
        }
        for (var unmatchedCousin : unmatchedCousinNames) {
            System.out.println("Debug: unmatched cousin found:" + unmatchedCousin);
        }
        for (var dupeCharacterName : dupeCharacters.keySet()) {
            System.out.println("Debug: Multiple characters found with the following name: " + dupeCharacterName + ". The wrong one may be selected as head of the house. Consider changing their name");
        }
    }

    /**
     * Merge dynasties between chracters and characters marked as their cousins.
     * Uses a very brittle system to do so, but on the other hand it's easy to use and can be done from the ingame character creator...
     * Cousins are haracters whose names match another living character with the name . It's brittle, but was used by me as a crude way to make families. Including their family.
     * <p>
     * Learning note:
     * Probably not as interesting to use for learning as the dna randomizer
     *
     * @param savegameNode Save node
     * @return Modified save node
     */
    public static Node mergeDynasties(Node savegameNode) {
        var landedCharacterNames = new ArrayList<String>();
        var landedCharactersByName = new HashMap<String, List<Tuple<Node, Optional<Node>>>>();
        var charactersWithCousinsNames = new TreeSet<String>();

        // living characters
        var living = savegameNode.getNodeForKey("living");
        // living dynasties
        var dynastyHouses = savegameNode.getNodeForKey("dynasties").getNodeForKey("dynasty_house");

        // Extract keys
        var livingPeopleKeys = new ArrayList<String>();
        living.forEach((nodeKey, node) -> {
            livingPeopleKeys.add(nodeKey);
        });


        //  Get initial list of cousins for data verification
        for (var nodeKey : livingPeopleKeys) {
            var characterNode = living.getNodeForKey(nodeKey);
            var name = characterNode.getNodeForKey("first_name").getString();
            OptionalInt dynasty_house_id = (characterNode.hasKey("dynasty_house")) ? OptionalInt.of(characterNode.getNodeForKey("dynasty_house").getInteger()) : OptionalInt.empty();

            if (name.contains("'s Cousin")) {
                var uncousin = name.substring(0, name.length() - "'s Cousin".length());
                charactersWithCousinsNames.add(uncousin);
            }

            Optional<Node> dynastyNode = Optional.empty();
            if (dynasty_house_id.isPresent()) {
                dynastyNode = Optional.ofNullable(dynastyHouses.getNodeForKey(String.valueOf(dynasty_house_id.getAsInt())));
            }
            if (dynasty_house_id.isEmpty()) {
                continue;
            }
            if (!characterNode.hasKey("landed_data")) {
                continue;
            }
            landedCharacterNames.add(name);
            var tuple = new Tuple<>(characterNode, dynastyNode);

            if (!landedCharactersByName.containsKey(name)) {
                landedCharactersByName.put(name, new ArrayList<>());
            }
            landedCharactersByName.get(name).add(tuple);
        }

        // Get cousin data for manual verification
        findDupeCousins(charactersWithCousinsNames, landedCharacterNames, landedCharactersByName);

        var problematicCousins = new ArrayList<Tuple<String, String>>();
        // Override landed cousin family dynasty
        for (var nodeKey : livingPeopleKeys) {
            var character = living.getNodeForKey(nodeKey);
            var name = character.getNodeForKey("first_name").getString();
            OptionalInt dynasty_house_id = (character.hasKey("dynasty_house")) ? OptionalInt.of(character.getNodeForKey("dynasty_house").getInteger()) : OptionalInt.empty();

            if (name.contains(" Cousin") && dynasty_house_id.isPresent() && character.hasKey("landed_data")) {

                var uncousin = name.substring(0, name.length() - "'s Cousin".length());
                if (!landedCharactersByName.containsKey(uncousin)) {
                    problematicCousins.add(new Tuple<>(name, uncousin));
                    continue;
                }

                var dynastyHeadCharacterNode = landedCharactersByName.get(uncousin).get(0).x;
                var correct_dynasty = dynastyHeadCharacterNode.getNodeForKey("dynasty_house").getValueNode();
                // Update character dynasty
                character.getNodeForKey("dynasty_house").getValueNode().set(correct_dynasty);

                // Update cousin's skills to be crappy
                var character_skills = character.getNodeForKey("skill");
                for (var character_skill : character_skills.getNodeArray()) {
                    character_skill.getValueNode().set(new ValueNode("2", false));
                }

                // Update cousin's family data
                if (character.hasKey("family_data")) {
                    var family_node = character.getNodeForKey("family_data");

                    // Update spouse
                    if (family_node.hasKey("primary_spouse")) {
                        // Update spouse dynasty
                        var primarySpouseId = family_node.getNodeForKey("primary_spouse");
                        var spouseNode = living.getNodeForKey(primarySpouseId.getString());
                        spouseNode.getNodeForKey("dynasty_house").getValueNode().set(correct_dynasty);

                        // Update skills
                        var spouseSkills = spouseNode.getNodeForKey("skill");
                        for (var spouse_skill : spouseSkills.getNodeArray()) {
                            spouse_skill.getValueNode().set(new ValueNode("2", false));
                        }
                    }

                    // Update children dynasty
                    if (family_node.hasKey("child")) {
                        var childrenNodes = family_node.getNodeForKey("child");
                        for (var childId : childrenNodes.getNodeArray()) {
                            var childNode = living.getNodeForKey(childId.getString());
                            childNode.getNodeForKey("dynasty_house").getValueNode().set(correct_dynasty);
                        }
                    }
                }
            }
        }

        for (var problematicCousin : problematicCousins) {
            System.out.println("Debug: unmatched cousin found:" + problematicCousin);
        }

    return savegameNode;
    }

    /**
     * Welcome to my PDXU usage example. It works with Crusader Kings 3 files. This code was originally used for setting up a personal campaign. I'm not familiar with Java so the code quality isn't amazing, but it should suffice as an API usage example.
     * Calling this main() with different arguments produces different results. I would make the cli fancier but coming from python let me tell you Argparse4j is no argparse.
     *
     * Side effects:
     *  decrypt - Decrypts dna given as an argument
     *  randomize_dna - Randomize DNA of all characters in a given
     *  merge_dynasties - Change characters named with the pattern "{character's name}'s Cousin" and their family to the matching "{character's name}" dynasty.
     * String arguments:
     * 1: Command. Choose the operation you want done. Options:
     *      randomize_dna
     *      merge_dynasties
     * 2: Optional: Path to a Crusader Kings save
     * 3: Optional: Path to output modified save
     * 4: Optional: Path to Crusader Kings 3's "rulers" directory
     * @param args See above
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String command = "decrypt";
        String decryptedDnaToEncrypt = "";
        Path originalSavePath = Path.of(System.getenv("USERPROFILE") + "\\documents\\personal\\crusader kings scripts\\pdxu_sample\\save.ck3");
        Path modifiedSavePath = Path.of(System.getenv("USERPROFILE") + "\\documents\\personal\\crusader kings scripts\\pdxu_sample\\save_modified.ck3");
        String  rulersDirectoryPath = System.getenv("USERPROFILE") + "\\Documents\\Paradox Interactive\\Crusader Kings III\\rulers";


        if (args.length > 0) {
            command = args[0];
        }
        if(command.equals("decrypt")){
            if (args.length > 1) {
                decryptedDnaToEncrypt = args[1];
            }
            else {
                System.out.println("No text to encrypt");
                return;
            }
        }
        else {
            if (args.length > 1) {
                originalSavePath = Path.of(args[1]);
            }
            if (args.length > 2) {
                modifiedSavePath = Path.of(args[2]);
            }
            if (args.length > 3) {
                rulersDirectoryPath = args[3];
            }
        }


        byte[] saveBytes = Files.readAllBytes(originalSavePath);
        SavegameType type = SavegameType.CK3;
        SavegameStructure structure = type.determineStructure(saveBytes);
        SavegameParseResult parseResult = structure.parse(saveBytes);
        var savegameNode = parseResult.success().orElseThrow().combinedNode();

        switch (command) {
            case "decrypt" -> DNA.decryptString(decryptedDnaToEncrypt);
            case "randomize_dna" ->
                    savegameNode = randomizeDna(savegameNode, getUntouchableIds(savegameNode, rulersDirectoryPath));
            case "merge_dynasties" -> savegameNode = mergeDynasties(savegameNode);
            default -> System.out.println("No command given :'(");
        }

        if(Arrays.asList("randomize_dna", "merge_dynasties").contains(command))
        {
            // Learning note:  Save as a compressed CK3 file
            SavegameStructure.CK3_COMPRESSED.write(modifiedSavePath, new SavegameContent(Map.of("gamestate", savegameNode.getArrayNode())));

        }

        // Learning note:  The following commented out code is how you save any node as plaintext
        // structure.write(outputFile, new SavegameContent(Map.of("gamestate", (ArrayNode) savegameNode)));


    }
}

