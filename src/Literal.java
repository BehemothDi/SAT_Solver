import java.util.Objects;

public class Literal {
    private int val;

    Literal(){

    }

    Literal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val){
        this.val = val;
    }

    public Literal invert(){
        this.val*= -1;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Literal literal = (Literal) o;
        return this.val == literal.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.val);
    }

    @Override
    public Literal clone(){
        return new Literal(this.val);
    }

    @Override
    public String toString(){
        return "" + this.val;
    }
}
