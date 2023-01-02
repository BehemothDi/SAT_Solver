import java.util.ArrayList;

public class Function {

    private ArrayList<Clause> clauses = new ArrayList<>();

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
        clause.addLiteral(literal);
        this.clauses.add(clause);
        return this;
    }

    public Function removeClause(Clause clause){
        this.clauses.removeIf(clause::equals);
        return this;
    }

    public void performUnitPropagation() {

    }

    public void processPureLiterals() {

    }

    public Literal chooseLiteral() {
        return null;
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
