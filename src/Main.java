public class Main {
    public static void main(String[] args) {

        Clause cl1 = new Clause(new int[] {1, 2, 3});
        Clause cl2 = new Clause(new int[] {1, -2, -3});
        Clause cl3 = new Clause(new int[] {-1});
        Clause cl4 = new Clause(new int[] {1, -4});
        Clause cl5 = new Clause(new int[] {4, 5, 6});

        Function function = new Function(), function1;
        function.addClause(cl1);
        function.addClause(cl2);
        function.addClause(cl3);
        function.addClause(cl4);
        function.addClause(cl5);

        function1 = function.clone();

       // function.addClause(cl1);

        System.out.println(function);

        System.out.println(DPLL.recursive(function));

    }
}