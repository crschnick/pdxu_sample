package com.crschnick.pdxu.sample;

import com.crschnick.pdxu.io.node.Node;
import com.crschnick.pdxu.io.savegame.SavegameParseResult;
import com.crschnick.pdxu.io.savegame.SavegameStructure;
import com.crschnick.pdxu.io.savegame.SavegameType;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        Path file = Path.of(args[0]);
        byte[] bytes = Files.readAllBytes(file);
        SavegameType type = SavegameType.CK3;
        SavegameStructure structure = type.determineStructure(bytes);

        SavegameParseResult parseResult = structure.parse(bytes);
        Node savegameNode = parseResult.success().orElseThrow().combinedNode();

        System.out.println("Parsed file " + file );
    }
}