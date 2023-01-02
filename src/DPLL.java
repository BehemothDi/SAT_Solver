public class DPLL {


    public static boolean recursive(Function function){
        function.performUnitPropagation();
        function.processPureLiterals();

        if (function.isEmpty()) return true;
        if (function.hasEmptyClause()) return false;

        Literal l = function.chooseLiteral();

        return recursive(function.addClause(l)) || recursive(function.addClause(l.invert()));
    }


    public static void iterative(){

    }


}
