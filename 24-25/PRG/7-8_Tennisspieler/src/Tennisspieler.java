public class Tennisspieler {
    public String name;
    public int alter;

    public int alterDifferenz(int alter){
        return Math.abs(alter - this.alter);
    }
}
