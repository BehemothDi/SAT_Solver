import java.util.ArrayList;

public class Function {

    ArrayList<Clause> clauses;

    Function(){

    }

    Function(ArrayList<Clause> clauses){
        this.clauses = clauses;
    }

    public boolean isEmpty(){
        return clauses.size() == 0;
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
        clause.literals.add(literal);
        this.clauses.add(clause);
        return this;
    }


    public void removeClause(Clause clause){
        this.clauses.removeIf(clause::equals);
    }

    public void performUnitPropagation() {

    }

    public void processPureLiterals() {

    }

    public Literal chooseLiteral() {
        return null;
    }
}
