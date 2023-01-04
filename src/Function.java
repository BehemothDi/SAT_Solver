import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Function {

    private ArrayList<Clause> clauses = new ArrayList<>();
    private ArrayList<Literal> literals = new ArrayList<>();

    Function(){
    }

    Function(ArrayList<Clause> clauses){
        this.clauses = clauses;
    }

    public boolean isEmpty(){
        return clauses.size() == 0;
    }

    public ArrayList<Literal> getLiterals() {
        return literals;
    }

    public boolean hasEmptyClause(){
        for (Clause c : clauses) if (c.isEmpty()) return true;
        return false;
    }

    public Function addClause(Clause clause){
        this.clauses.add(clause);
        return this;
    }

    public Function addClause(Literal literal){
        Clause clause = new Clause();
        clause.addLiteral(literal);
        this.clauses.add(clause);
        return this;
    }

    public Function removeClause(Clause clause){
        this.clauses.removeIf(clause::equals);
        return this;
    }

    public void performUnitPropagation() {
        while (true) {
            Clause unitClause = this.findUnitClause();
            Literal unitLiteral, inverseUnitLiteral;

            if (unitClause != null) {
                unitLiteral = unitClause.getLiterals().get(0);
                literals.add(unitLiteral.clone());
            }
            else break;


            inverseUnitLiteral = unitLiteral.clone().invert();

            Function temp = this.clone();

            this.clauses.forEach(clause -> {
                if (clause.contains(unitLiteral)) temp.removeClause(clause);
            });
            this.clauses = temp.clauses;

            this.clauses.forEach(clause -> clause.removeLiteral(inverseUnitLiteral));
        }
    }

    private Clause findUnitClause() {
        for (Clause c : clauses) if (c.size() == 1) return c;
        return null;
    }

    public void processPureLiterals() {

    }

    public Literal chooseLiteral() {
        Literal l = this.clauses.get(0).getLiterals().get(0);
        literals.add(l);
        return l;
    }

    public void removeLiteral(Literal literal){
        this.clauses.forEach(clause -> clause.removeLiteral(literal));
    }
    @Override
    public Function clone(){
        Function function = new Function();
        this.clauses.forEach(cl -> function.addClause(cl.clone()));
        return function;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        this.clauses.forEach(cl -> res.append(cl.toString()).append("\n"));
        return res.toString();
    }
}
