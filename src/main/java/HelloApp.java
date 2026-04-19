public class HelloApp {
    public static void main(String[] args) {
        String names;

        if (args.length == 0) {
            names = "World";
        } else {
            StringBuilder nameBuilder = new StringBuilder();

            for (String name : args) {
                if (nameBuilder.length() > 0) {
                    nameBuilder.append(", ");
                }

                nameBuilder.append(name);
            }

            names = nameBuilder.toString();
        }

        System.out.println("Hello, " + names + "!");
    }
}
