public class Main {
    public static void main(String[] args) {
        GreetingsMessage greetingsMessage = new GreetingsMessage() {
            @Override
            public void greet(String name) {
                System.out.println("Hello There, " + name + "!!");
            }
        };
        greetingsMessage.greet("Rakesh");
        GreetingsMessage greetingsMessage1 = name -> {
            System.out.println("Hello " + name + " :-)");
        };
        greetingsMessage1.greet("RP");
    }
}
