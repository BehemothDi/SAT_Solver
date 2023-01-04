import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Clause {
    private ArrayList<Literal> literals = new ArrayList<>();

    Clause(){
    }

    Clause(ArrayList<Literal> literals) {
        this.literals = literals;
    }

    Clause(int[] literals) {
       for (int l : literals) {
           this.literals.add(new Literal(l));
       }
    }

    public ArrayList<Literal> getLiterals() {
        return literals;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public void addLiteral(Literal l){
        this.literals.add(l);
    }

    public void removeLiteral(Literal l){
        this.literals.removeIf(l::equals);
    }

    public int size(){
        return this.literals.size();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Clause clause = (Clause) o;
        if (this.literals.size() != clause.literals.size()) return false;
        return this.literals.equals(clause.literals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(literals);
    }

    @Override
    public Clause clone(){
        Clause clause = new Clause();
        this.literals.forEach(l -> clause.addLiteral(l.clone()));
        return clause;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        this.literals.forEach(l -> s.append(l.toString()).append(" "));
        return "{" + s.toString().trim() + "}";
    }

    public boolean contains(Literal literal) {
        for (Literal l : this.literals) if (l.equals(literal)) return true;
        return false;
    }
}
