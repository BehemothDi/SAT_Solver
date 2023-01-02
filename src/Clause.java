import java.util.ArrayList;
import java.util.Objects;

public class Clause {
    ArrayList<Literal> literals;

    Clause(){
        this.literals = new ArrayList<>();
    }

    Clause(ArrayList<Literal> literals) {
        this.literals = literals;
    }

    public boolean isEmpty(){
        return literals.size() == 0;
    }

    public void addLiteral(Literal l){
        this.literals.add(l);
    }

    public void removeLiteral(Literal l){
        this.literals.removeIf(l::equals);
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
}
