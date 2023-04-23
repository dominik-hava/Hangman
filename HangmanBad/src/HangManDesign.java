public class HangManDesign {
    public static String printHangMan(int phase){
        switch (phase) {
            case 0 -> {
                return
                        """
                                      +
                                      |
                                      |
                                      |
                                      |
                                      |
                                =========
                                """;
            }
            case 1 -> {
                return
                        """
                                  +---+
                                  |   |
                                      |
                                      |
                                      |
                                      |
                                =========
                                """;
            }
            case 2 -> {
                return
                        """
                                  +---+
                                  |   |
                                  O   |
                                      |
                                      |
                                      |
                                =========
                                """;
            }
            case 3 -> {
                return
                        """
                                  +---+
                                  |   |
                                  O   |
                                  |   |
                                      |
                                      |
                                =========
                                """;
            }
            case 4 -> {
                return
                        """
                                  +---+
                                  |   |
                                  O   |
                                 /|\\ |
                                      |
                                      |
                                =========
                                """;
            }
            case 5 -> {
                return
                        """
                                  +---+
                                  |   |
                                  O   |
                                 /|\\ |
                                 / \\ |
                                      |
                                =========
                                """;
            }
            default -> throw new IllegalStateException("Unexpected value: " + phase);
        }
    }
}