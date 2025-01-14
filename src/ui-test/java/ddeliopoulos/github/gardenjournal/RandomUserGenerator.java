package ddeliopoulos.github.gardenjournal;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class RandomUserGenerator {

    private final static List<String> POSITIVE_PERSONALITY_ADJECTIVES = asList(
            "aggressive",
            "agreeable",
            "ambitious",
            "brave",
            "calm",
            "delightful",
            "eager",
            "faithful",
            "gentle",
            "happy",
            "jolly",
            "kind",
            "lively",
            "nice",
            "obedient",
            "polite",
            "proud",
            "silly",
            "thankful",
            "victorious",
            "witty",
            "wonderful",
            "zealous"
    );

    private final static List<String> SOUND_ADJECTIVES = asList(
            "crashing",
            "deafening",
            "echoing",
            "faint",
            "harsh",
            "hissing",
            "howling",
            "loud",
            "melodic",
            "noisy",
            "purring",
            "quiet",
            "rapping",
            "raspy",
            "rhythmic",
            "screeching",
            "shrilling",
            "squeaking",
            "thundering",
            "tinkling",
            "wailing",
            "whining",
            "whispering"
    );

    private final static List<String> TIME_ADJECTIVES = asList(
            "ancient",
            "brief",
            "early",
            "fast",
            "future",
            "late",
            "long",
            "modern",
            "old",
            "old",
            "prehistoric",
            "quick",
            "rapid",
            "short",
            "slow",
            "swift",
            "young"
    );

    private final static List<String> TASTE_ADJECTIVES = asList(
            "acidic",
            "bitter",
            "cool",
            "creamy",
            "delicious",
            "disgusting",
            "fresh",
            "greasy",
            "juicy",
            "hot",
            "moldy",
            "nutritious",
            "nutty",
            "putrid",
            "rancid",
            "ripe",
            "rotten",
            "salty",
            "savory",
            "sour",
            "spicy",
            "spoiled",
            "stale",
            "sweet",
            "tangy",
            "tart",
            "tasteless",
            "tasty",
            "yummy"
    );

    private final static List<String> ANIMAL_NAMES = asList(
            "aardvark",
            "albatross",
            "alligator",
            "alpaca",
            "ant",
            "anteater",
            "antelope",
            "ape",
            "armadillo",
            "baboon",
            "badger",
            "barracuda",
            "bat",
            "bear",
            "beaver",
            "bee",
            "bison",
            "boar",
            "buffalo",
            "butterfly",
            "camel",
            "capybara",
            "caribou",
            "cassowary",
            "cat",
            "caterpillar",
            "cattle",
            "chamois",
            "cheetah",
            "chicken",
            "chimpanzee",
            "chinchilla",
            "chough",
            "clam",
            "cobra",
            "cockroach",
            "cod",
            "cormorant",
            "coyote",
            "crab",
            "crane",
            "crocodile",
            "crow",
            "curlew",
            "deer",
            "dinosaur",
            "dog",
            "dogfish",
            "dolphin",
            "donkey",
            "dotterel",
            "dove",
            "dragonfly",
            "duck",
            "dugong",
            "dunlin",
            "eagle",
            "echidna",
            "eel",
            "eland",
            "elephant",
            "elephant-seal",
            "elk",
            "emu",
            "falcon",
            "ferret",
            "finch",
            "fish",
            "flamingo",
            "fly",
            "fox",
            "frog",
            "gaur",
            "gazelle",
            "gerbil",
            "giant-panda",
            "giraffe",
            "glopi",
            "gnat",
            "gnu",
            "goat",
            "goose",
            "goldfinch",
            "goldfish",
            "gorilla",
            "goshawk",
            "grasshopper",
            "grouse",
            "guanaco",
            "guinea-fowl",
            "guinea-pig",
            "gull",
            "hamster",
            "hare",
            "hawk",
            "hedgehog",
            "heron",
            "herring",
            "hippopotamus",
            "hornet",
            "horse",
            "human",
            "hummingbird",
            "hyena",
            "ibex",
            "ibis",
            "jackal",
            "jaguar",
            "jay",
            "jellyfish",
            "kangaroo",
            "kingfisher",
            "koala",
            "komodo-dragon",
            "kookabura",
            "kouprey",
            "kudu",
            "lapwing",
            "lark",
            "lemur",
            "leopard",
            "lion",
            "llama",
            "lobster",
            "locust",
            "loris",
            "louse",
            "lyrebird",
            "magpie",
            "mallard",
            "manatee",
            "mandrill",
            "mantis",
            "marten",
            "meerkat",
            "mink",
            "mole",
            "mongoose",
            "monkey",
            "moose",
            "mouse",
            "mosquito",
            "mule",
            "narwhal",
            "newt",
            "nightingale",
            "octopus",
            "okapi",
            "opossum",
            "oryx",
            "ostrich",
            "otter",
            "owl",
            "ox",
            "oyster",
            "panther",
            "parrot",
            "partridge",
            "peafowl",
            "pelican",
            "penguin",
            "pheasant",
            "pig",
            "pigeon",
            "polar-bear",
            "pony",
            "porcupine",
            "porpoise",
            "prairie-dog",
            "quail",
            "quelea",
            "quetzal",
            "rabbit",
            "raccoon",
            "rail",
            "ram",
            "rat",
            "raven",
            "red-deer",
            "red-panda",
            "reindeer",
            "rhinoceros",
            "rook",
            "salamander",
            "salmon",
            "sand-dollar",
            "sandpiper",
            "sardine",
            "scorpion",
            "sea-lion",
            "sea-urchin",
            "seahorse",
            "seal",
            "shark",
            "sheep",
            "shrew",
            "skunk",
            "snail",
            "snake",
            "sparrow",
            "spider",
            "spoonbill",
            "squid",
            "squirrel",
            "starling",
            "stingray",
            "stinkbug",
            "stork",
            "swallow",
            "swan",
            "tapir",
            "tarsier",
            "termite",
            "tiger",
            "toad",
            "trout",
            "turkey",
            "turtle",
            "vicuña",
            "viper",
            "vulture",
            "wallaby",
            "walrus",
            "wasp",
            "water-buffalo",
            "weasel",
            "whale",
            "wolf",
            "wolverine",
            "wombat",
            "woodcock",
            "woodpecker",
            "worm",
            "wren",
            "yak",
            "zebra"
    );

    private final static Random RANDOM = new Random();

    private static <T> T randomElement(final List<T> elements) {
        return elements.get(RANDOM.nextInt(elements.size()));
    }

    private static String randomAdjective() {
        return randomElement(
                asList(
                        randomElement(POSITIVE_PERSONALITY_ADJECTIVES),
                        randomElement(SOUND_ADJECTIVES),
                        randomElement(TASTE_ADJECTIVES),
                        randomElement(TIME_ADJECTIVES)
                )
        );
    }

    private static String randomAnimal() {
        return randomElement(ANIMAL_NAMES);
    }

    public static String randomUsername() {
        return randomAdjective() + '-' + randomAnimal();
    }

}
