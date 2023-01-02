public class Main {
    public static void main(String[] args) {

        Clause cl1 = new Clause(new int[] {1, 2, 3});
        Clause cl2 = new Clause(new int[] {1, -2, -3});
        Clause cl3 = new Clause(new int[] {-1, -2, 3});

        Function function = new Function(), function1;
        function.addClause(cl1);
        function.addClause(cl2);
        function.addClause(cl3);

        function1 = function.clone();

        function.addClause(cl1);
        function.removeLiteral(new Literal(-1));

        System.out.println(function);
        System.out.println(function1);

    }
}