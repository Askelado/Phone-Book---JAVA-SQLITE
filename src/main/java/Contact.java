public class Contact {

    private String name;
    private int phonenum;
    private String relation;
    private int ID;
    public static int IDcounter=1;

    public Contact(String name, int phonenum, String relation) {
            this.name = name;
            this.phonenum = phonenum;
            this.relation = relation;
            ID = IDcounter;
            IDcounter++;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    @Override
    public String toString() {
        return  "---------"+
                ID+"\t\t" +
                name+
                "\t\t"+
                phonenum+
                "\t\t" +
                relation+
                "---------\n";
    }
}


