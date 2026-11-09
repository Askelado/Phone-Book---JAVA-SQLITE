public class Contact {

    private String name;
    private int phonenum;
    private String relation;

    public Contact(String name, int phonenum, String relation) {
            this.name = name;
            this.phonenum = phonenum;
            this.relation = relation;
        }
    public Contact() {
    }

    public void setname(String name){
        this.name=name;
    }

    public String getname(){
        return name;
    }

    public int getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(int phonenum) {
        this.phonenum = phonenum;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "---------"+
                name+
                "\t\t"+
                phonenum+
                "\t\t" +
                relation+
                "---------\n";
    }
}


