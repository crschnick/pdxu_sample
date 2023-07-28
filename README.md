
# PDXU Example Project

Welcome to my PDXU usage example. You can use it to learn how to use PDXU's API to parse Paradox's propietary format- Concretely: Crusader Kings 3 save files and plaintext Crusader Kings 3 "rulers" files.

This code was originally used for setting up a personal campaign. I'm not familiar with Java so the code quality isn't amazing, but it should suffice as an API usage example.

## File structure
`src\main\java\com\crschnick\pdxu\sample\DNA.java` - A functional-style class that has functions that handle Crusader Kings 3 character DNA manipulation.

`src\main\java\com\crschnick\pdxu\sample\Main.java` - Holds the main logic used to perform various save file manipulations

`src\main\java\com\crschnick\pdxu\sample\Tuple.java` - Just a helper class, nothing to see here.

## Learning
Look up the string "Learning note" in the code base to find examples on how to use PDXU's API.

The short of it is that PDXU parses save files into abstract "nodes" that can be dynamically cast or calculated into more concrete types such as:
A "value node" holding a key and value such as a string or an integer.
An "array node" which holds an array of other nodes with keys and indexes. Index (the place of the leaf-node within its parent/root) can matter in these type of files!

In this example you can learn how to change the value of value nodes, and how to augment array nodes with new value nodes (which is a little tricky).

## Running

To build and run this project, you need at least Java 19. It is recommended that you use IntelliJ as other IDEs run into problems with Java modules.

Running `./gradlew run` with different arguments produces different results:

- `decrypt` - Decrypts base64 encrypted dna, given as an argument
- `randomize_dna {Optional: Path to a Crusader Kings save} {Optional: Path to output modified save} {Optional: Path to Crusader Kings 3's "rulers" directory}` - Randomize DNA of all characters in a given
- `merge_dynasties {Optional: Path to a Crusader Kings save} {Optional: Path to output modified save} {Optional: Path to Crusader Kings 3's "rulers" directory}` - Change characters named with the pattern `{character's name}'s Cousin` and their family to the matching `{character's name}`'s dynasty.

