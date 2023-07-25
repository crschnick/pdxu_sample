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
    public static Set<String> Get_Untouchables() throws IOException, ParseException {


        File rulers_directory = new File(System.getenv("USERPROFILE") + "\\Documents\\Paradox Interactive\\Crusader Kings III\\rulers");
        File[] files = rulers_directory.listFiles(File::isFile);

        Set<String> untouchable_names = new HashSet<>();
        Set<String> untouchable_ids = new HashSet<>();

        // ####################################
        // ## get premade character names##
        // ####################################
        assert files != null;
        for(var file: files){
            var node = TextFormatParser.ck3().parse(Path.of(file.toURI()));
            untouchable_names.add(node.getNodeForKey("ruler").getNodeForKey("config").getNodeForKey("name").toString());
        }

        // ####################################
        // ## get cousins and their families ##
        // ####################################
        Path file = Path.of(System.getenv("USERPROFILE") + "\\documents\\personal\\crusader kings scripts\\pdxu_sample\\save.ck3");

        byte[] bytes = Files.readAllBytes(file);
        SavegameType type = SavegameType.CK3;
        SavegameStructure structure = type.determineStructure(bytes);
        SavegameParseResult parseResult = structure.parse(bytes);
        var savegameNode = parseResult.success().orElseThrow().combinedNode();
        var living = savegameNode.getNodeForKey("living");
        var living_people_keys = new ArrayList<String>();
        var uncousin_names = new TreeSet<String>();



        living.forEach((node_key, node) -> {
            living_people_keys.add(node_key);
        });
        // Get initial list of uncousins
        for (var node_key : living_people_keys) {
            var character = living.getNodeForKey(node_key);
            var name = character.getNodeForKey("first_name").getString();
            OptionalInt dynasty_house_id = (character.hasKey("dynasty_house")) ? OptionalInt.of(character.getNodeForKey("dynasty_house").getInteger()) : OptionalInt.empty();

            if(name.contains("Cousin")){
                var uncousin = name.substring(0,name.length() -"'s Cousin".length());
                if(containsAny(uncousin, "'s 1","'s 2", "'s 3", "'s 4", "'s 5")){
                    uncousin = name.substring(0,uncousin.length() - "'s 1".length());
                }
                if(name.contains("'s Cousin's Cousin")){
                    uncousin = name.substring(0,name.length() -"'s Cousin's Cousin".length());
                }
                if(uncousin.equals("Christina Posabulel")){
                    uncousin="Christina Posabule";
                }
                if(uncousin.equals("Khashayar")){
                    uncousin="Khashayarbee";
                }
                uncousin_names.add(uncousin);
            }
        }

        // ####################################
        // ## Mark untouchable ##
        // ####################################
        for (var node_key : living_people_keys) {

            var character = living.getNodeForKey(node_key);
            var name = character.getNodeForKey("first_name").getString();

            if (name.contains(" Cousin") || uncousin_names.contains(name) || untouchable_names.contains(name)) {

                // Mark untouchable
                untouchable_ids.add(node_key);
                if(untouchable_ids.contains("18151")){
                    var x =1;
                }

                // Untouch family data
                if (character.hasKey("family_data")) {
                    var family_node = character.getNodeForKey("family_data");

                    // Untouch spouse
                    if(family_node.hasKey("primary_spouse"))
                    {
                        var primary_spouse_id = family_node.getNodeForKey("primary_spouse");
                        untouchable_ids.add(primary_spouse_id.getString());
                        if(untouchable_ids.contains("18151")){
                            var x =1;
                        }
                    }
                    // Untouch kidz
                    if(family_node.hasKey("child")) {
                        var children = family_node.getNodeForKey("child");
                        for (var child_id : children.getNodeArray()) {
                            untouchable_ids.add(child_id.getString());
                            if(untouchable_ids.contains("18151")){
                                var x =1;
                            }
                        }
                    }

                }
            }
        }


            var x = 0;
        return untouchable_ids;



    }

    public static void Randomize_DNA(Node savegameNode, Path output_file) throws IOException, ParseException {
        var untouchable_ids = Get_Untouchables();
//        Set<String> untouchable_ids = new HashSet<>();
        var living = savegameNode.getNodeForKey("living");
        // Extract keys
        var living_people_keys = new ArrayList<String>();
        living.forEach((node_key, node) -> {
            living_people_keys.add(node_key);
        });

        Queue<String> random_dna_queue = new LinkedList<>();
        for(int i=0; i <living_people_keys.size(); i++){
//        for(int i=0; i <2; i++){
            random_dna_queue.offer(DNA.Create_Random_DNA());
        }
//        // Ruin their DNA... they deserve it.
//            var node_key = "18151";
        for (var node_key : living_people_keys) {
            var character = living.getNodeForKey(node_key);
            var name = character.getNodeForKey("first_name").getString();

            if (!untouchable_ids.contains(node_key)){
                System.out.println("destroying " + node_key + ", name: " + name);
                var random_dna_string = Objects.requireNonNull(random_dna_queue.poll());
                var randomized_dna_array_node = ArrayNode.singleKeyNode("dna", new ValueNode(random_dna_string, true));

                if (character.hasKey("dna")) {
                    var randomized_dna = new ValueNode(random_dna_string, true);;
                    var old_dna = character.getNodeForKey("dna");
                    var old_dna_string = old_dna.toString();
                    ((ValueNode) old_dna).set(randomized_dna);
                    var new_dna_string = old_dna.toString();
                }
                else{
                    character = character.getArrayNode().replacePart(randomized_dna_array_node, 0, 0);
                    var new_dna_string = character.getNodeForKey("dna").toString();
                    living = living.getArrayNode().replaceKey(node_key, character);
                    savegameNode = savegameNode.getArrayNode().replaceKey("living", living);

                }



//                System.out.println("old_dna_string " + old_dna_string);
//                System.out.println("new_dna_string " + new_dna_string);

//                break;

            }
        }
        SavegameStructure.CK3_COMPRESSED.write(output_file, new SavegameContent(Map.of("gamestate", (ArrayNode) savegameNode)));




    }

        public static void main(String[] args) throws Exception {

//        DNA.create_random_dna();
//        rightie
//            DNA.decrypt("/v5i+v//aZP7/zbjAP8AcwH/AYoB/wGLAf8BjAH/AZoB/wGFAP8AdQD/AHgA/wBzAP8AcQH/AaEB/wGIAP8AZwH/AZIB/wGeAP8AZgH/AYYB/wGlAP8AZwD/AHwB/wGDAf8BsAD/AHUA/wB4AP8AcgH/AYAA/wB8Af8BjwH/AdsA/wAfAP8AZwH/AYwB/wAWAf8AJQH/ACsB/wEKAP8AegL/ACIB/wFTAf8BBwH/AeoB/wC1Af8AMwH/AQEB/wBjAf8BLQH/ARIB/wEFAf8AFQH/AAkA/wAsAf8AJgH/AW8B/wBEAP8AGQH/AQkB/wENAP8AEAH/AKwB/wFLAf8AKwH/ABAB/wEqAf8ACwH/AQoB/wBqA/8AAQH/ACIB/wEiAf8AEgH/AC0B/wALAf8ABwH/ABkE/wOeAf8BDQH/ATUA/wCzBf8B0wP/ALQB/wAGAP8AmwD/AIMD/wBlAP4A/gL/AskC/wIABv8CvwH/AXMD/wGHC/8IAADMB78D/wIsDP8D/wT/AeEF/wDRAV8BXwB/AH8AnwCfAAAAAAHhAeE=");
//        leftie
//        DNA.decrypt("AgFi+gQDaZMAAjbjAAAAcwEAAYoBAAGLAQABjAEAAZoBAAGFAAAAdQAAAHgAAABzAAAAcQEAAaEBAAGIAAAAZwEAAZIBAAGeAAAAZgEAAYYBAAGlAAAAZwAAAHwBAAGDAQABsAAAAHUAAAB4AAAAcgEAAYAAAAB8AQABjwEAAdsAAAAfAAAAZwEAAYwA/wAWAP8AJQD/ACsA/wEKAAAAegAAACIA/wFTAP8BBwD/AeoA/wC1AP8AMwD/AQEA/wBjAP8BLQD/ARIA/wEFAP8AFQD/AAkAAAAsAP8AJgD/AW8A/wBEAAAAGQD/AQkA/wENAAAAEAD/AKwA/wFLAP8AKwD/ABAA/wEqAP8ACwD/AQoA/wBqAP8AAQD/ACIA/wEiAP8AEgD/AC0A/wALAP8ABwAAABkAAAOeAAABDQAAATUAAACzAAAB0wAAALQAAAAGAAAAmwAAAIMAAABlAP4A/gAAAskCAAIAAAACvwEAAXMBBwGHAQAIAAAAB78AAAIsAAAD/wAAAeEAAADRAV8BXwB/AH8AnwCfAAAAAAHhAeE=");

//        normal dude
//        DNA.decrypt("U/dX+mmIZotK80jZAYsAYgGBAGkAdAB7AYwAfQGCAYMBiwGNAYUBlQGEAYMAZwBrAZgAeAGhAYMBkwBmACoANAAbAGYAZwBrAHEBgAF/AYABoQBvAZgAZgB/AHUAfQGAAGsAagGDAHcBiQGJAYsAdAGFAaEBnQBWAZYBngHVAYAAWgA1AG8BggF/AagAFQEgAA0AFQEmASMBAAAuAFAAxQEDAFgBQgFJASEANQGtAbkBFAG8AHkBngALAC4AQgEhAXwBCwAPAQQBBgEVABIAAwAEAEYAMgBSAXUBFgBwASQAdwERADMACQAaAAcAMQEsAB0AIwA+AU0BzgAHABQBDQA6AQEBDQANAAoBCQAiAQkAFQAqASsAEwAbAAMBAQAVAXoBYgBWABUBGwEvAC0AFwEHAIcB1AI8ABEBQAEIABgABwDHAQ0F5QABARQAtwHwAOoA+QB8APcD6gEdAFABygGzAekCAAIAA9wBtAF0AYQBjwOEAgcKPQOcApACzwBWBbcL8gH5A+ICywHhAp0BbAB/AH8AJQAlAAAAAAFVAVU=");
//        Get_Untouchables();



        Path file = Path.of(System.getenv("USERPROFILE") + "\\documents\\personal\\crusader kings scripts\\pdxu_sample\\save.ck3");
        Path output_file = Path.of(System.getenv("USERPROFILE") + "\\documents\\personal\\crusader kings scripts\\pdxu_sample\\save_modified.ck3");
        byte[] bytes = Files.readAllBytes(file);
        SavegameType type = SavegameType.CK3;
        SavegameStructure structure = type.determineStructure(bytes);


        SavegameParseResult parseResult = structure.parse(bytes);
        var savegameNode = parseResult.success().orElseThrow().combinedNode();

        Randomize_DNA(savegameNode,output_file);
        if(true){
            return;
        }


        // living characters
        var living = savegameNode.getNodeForKey("living");
        // living dynasties
        var dynasty_houses = savegameNode.getNodeForKey("dynasties").getNodeForKey("dynasty_house");

        // Extract keys
        var living_people_keys = new ArrayList<String>();
        living.forEach((node_key, node) -> {
            living_people_keys.add(node_key);
                });


//        get kens
//        var kens = new ArrayList<Node>();
        var kens_dynastic_id = 6757;
        var earliest_dynasty = 5919;

        var probably_made_character_names = new ArrayList<String>();
        var probably_made_characters_by_name = new HashMap<String, List<Tuple<Node,Optional<Node>>>>();
        var dupe_characters = new HashMap<String, List<Tuple<Node,Optional<Node>>>>();

        var suspect_dupes = new ArrayList<Node>();
        var uncousin_names = new TreeSet<String>();

//        Get initial list of cousins for data verification
        for (var node_key : living_people_keys) {
            var character = living.getNodeForKey(node_key);
            var name = character.getNodeForKey("first_name").getString();
            OptionalInt dynasty_house_id = (character.hasKey("dynasty_house")) ? OptionalInt.of(character.getNodeForKey("dynasty_house").getInteger()) : OptionalInt.empty();

            if(name.contains(" Cousin")){

                var uncousin = name.substring(0,name.length() -"'s Cousin".length());
                if(containsAny(uncousin, "'s 1","'s 2", "'s 3", "'s 4", "'s 5")){
                    uncousin = name.substring(0,uncousin.length() - "'s 1".length());
                }
                if(name.contains("'s Cousin's Cousin")){
                    uncousin = name.substring(0,name.length() -"'s Cousin's Cousin".length());
                }
                if(uncousin.equals("Christina Posabulel")){
                    uncousin="Christina Posabule";
                }
                if(uncousin.equals("Khashayar")){
                    uncousin="Khashayarbee";
                }
                uncousin_names.add(uncousin);
            }


            Optional<Node> dynasty_node = Optional.empty();
            if(dynasty_house_id.isPresent()){
                dynasty_node = Optional.ofNullable(dynasty_houses.getNodeForKey(String.valueOf(dynasty_house_id.getAsInt())));
            }
            if (dynasty_house_id.isEmpty()){
                continue;
            }
            if(!character.hasKey("landed_data")){
                continue;
            }
            probably_made_character_names.add(name);
            var tuple =new Tuple<>(character, dynasty_node);

            if (!probably_made_characters_by_name.containsKey(name)) {
                probably_made_characters_by_name.put(name, new ArrayList<>());
            }
            probably_made_characters_by_name.get(name).add(tuple);
        }

//        Get cousin data for manual verification
        var unmatched_cousin_names = new ArrayList<String>();
        for(var name: uncousin_names) {
            if (Collections.frequency(probably_made_character_names, name) > 1) {
//                var characters_list = probably_made_characters_by_name.get(name);

                dupe_characters.put(name, new ArrayList<>());
                dupe_characters.get(name).addAll(probably_made_characters_by_name.get(name));
                continue;
            }
            if (Collections.frequency(probably_made_character_names, name) < 1) {
                unmatched_cousin_names.add(name);
                continue;
            }
            var dynasty_head_character = probably_made_characters_by_name.get(name).get(0).x;
            var correct_dynasty = dynasty_head_character.getNodeForKey("dynasty_house").getInteger();
        }



        var uuuh_problem_cousins = new ArrayList<Tuple<String, String>>();
//        Override landed cousin family dynasty
        for (var node_key : living_people_keys) {
            var character = living.getNodeForKey(node_key);
            var name = character.getNodeForKey("first_name").getString();
            OptionalInt dynasty_house_id = (character.hasKey("dynasty_house")) ? OptionalInt.of(character.getNodeForKey("dynasty_house").getInteger()) : OptionalInt.empty();

            if (name.contains(" Cousin") && dynasty_house_id.isPresent() && character.hasKey("landed_data")) {

                var uncousin = name.substring(0, name.length() - "'s Cousin".length());
                if (containsAny(uncousin, "'s 1", "'s 2", "'s 3", "'s 4", "'s 5")) {
                    uncousin = name.substring(0, uncousin.length() - "'s 1".length());
                }
                if (name.contains("'s Cousin's Cousin")) {
                    uncousin = name.substring(0, name.length() - "'s Cousin's Cousin".length());
                }
                if(!probably_made_characters_by_name.containsKey(uncousin)){

                    switch (uncousin) {
                        case "Irish Jimmy's Mom" -> uncousin = "Irish Jimmy";
                        case "Elasticman" -> uncousin = "Elasticgirl";
                        case "My Own Fiona" -> uncousin = "Shrek";
                        default -> {
                            uuuh_problem_cousins.add(new Tuple<>(name, uncousin));
                            continue;
                        }
                    }
                }

                var dynasty_head_character = probably_made_characters_by_name.get(uncousin).get(0).x;
                var correct_dynasty = (ValueNode) dynasty_head_character.getNodeForKey("dynasty_house");
                //                Update character dynasty
                ((ValueNode) character.getNodeForKey("dynasty_house")).set(correct_dynasty);

                // Update skills
                var character_skills = character.getNodeForKey("skill");
                for(var character_skill: character_skills.getNodeArray()){
                    ((ValueNode) character_skill).set(new ValueNode("2", false));
                }

                // Update family data
                if (character.hasKey("family_data")) {
                    var family_node = character.getNodeForKey("family_data");

                    // Update spouse
                    if(family_node.hasKey("primary_spouse"))
                    {
                    // Update spouse dynasty
                        var primary_spouse_id = family_node.getNodeForKey("primary_spouse");
                        var spouse = living.getNodeForKey(primary_spouse_id.getString());
                        ((ValueNode) spouse.getNodeForKey("dynasty_house")).set(correct_dynasty);

                        // Update skills
                        var spouse_skills = spouse.getNodeForKey("skill");
                        for(var spouse_skill: spouse_skills.getNodeArray()){
                            ((ValueNode) spouse_skill).set(new ValueNode("2", false));
                        }
                    }

                    if(family_node.hasKey("child")) {
                        var children = family_node.getNodeForKey("child");
                        for (var child_id : children.getNodeArray()) {
                            var child = living.getNodeForKey(child_id.getString());
                            ((ValueNode) child.getNodeForKey("dynasty_house")).set(correct_dynasty);
                        }
                    }

                }


            }
        }



        var x =34;

        structure.write(output_file, new SavegameContent(Map.of("gamestate", (ArrayNode) savegameNode)));

//        try (var out = Files.newOutputStream(output_file)) {
//            NodeWriter.write(out, TextFormatParser.ck3().getCharset(), savegameNode.getArrayNode(), "\\t", 0);
//        }
    }
}

