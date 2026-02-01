import java.util.*;
public class HighStakesAuctioneer {
    static class Bid {
        String user;
        int amount;
        Bid(String user, int amount) {
            this.user = user;
            this.amount = amount;
        }
    }
    static Stack<Bid> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String command = parts[0];
            switch (command) {
                case "BID": {
                    String user = parts[1];
                    int amount = Integer.parseInt(parts[2]);
                    if (!stack.isEmpty() && amount <= stack.peek().amount) {
                        System.out.println("Error: Too low.");
                        break;
                    }
                    stack.push(new Bid(user, amount));
                    System.out.println("Current: " + user + " (" + amount + ")");
                    printStack();
                    break;
                }
                case "WITHDRAW": {
                    if (stack.isEmpty()) {
                        System.out.println("Error: No bids to withdraw.");
                        break;
                    }
                    Bid removed = stack.pop();
                    System.out.println(removed.user + " retracted.");
                    if (!stack.isEmpty()) {
                        Bid top = stack.peek();
                        System.out.println("Reverted to " + top.user + " (" + top.amount + ").");
                    } else {
                        System.out.println("No active bids.");
                    }
                    printStack();
                    break;
                }
                case "CURRENT": {
                    if (stack.isEmpty()) {
                        System.out.println("No active bids.");
                    } else {
                        Bid top = stack.peek();
                        System.out.println("Current: " + top.user + " (" + top.amount + ")");
                    }
                    break;
                }
                default:
                    System.out.println("Unknown command.");
            }
        }
        sc.close();
    }
    static void printStack() {
        System.out.print("Stack: [");
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i).amount);
            if (i < stack.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}