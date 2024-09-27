package paqueteJuegos;
public class Monstruos {
    private int fuer;
    private int dex;
    private int con;
    private int inte;
    private int sab;
    private int car;
    private int def;
    private int pG;
    private int golpetazo;
    private int golpetazoDanio;
    private int pGActualesArm;
        
    public Monstruos(int fuer, int dex, int con, int inte, int sab, int car,
        int def, int pG, int golpetazo, int golpetazoDanio, int pGActualesArm){
        this.fuer = fuer;
        this.dex = dex;
        this.con = con;
        this.inte = inte;
        this.sab = sab;
        this.car = car;
        this.def = def;
        this.pG = pG;
        this.golpetazo = golpetazo;
        this.golpetazoDanio = golpetazoDanio;
        this.pGActualesArm = pGActualesArm;
        }

 //Getters
public int getfuer(){
    return fuer;
}
public int getdex(){
    return dex;
}
public int getcon(){
    return con;
}
public int getinte(){
    return inte;
}
public int getsab(){
    return sab;
}
public int getcar(){
    return car;
}
public int getdef(){
    return def;
}
public int getpG(){
    return pG;
} 
public int getgolpetazo(){
    return golpetazo;
}
public int getgolpetazoDanio(){
    return golpetazoDanio;
}
public int getpGActualesArm(){
    return pGActualesArm;
}
//Setters
public void setFuer(int fuer) {
    this.fuer = fuer;
}

public void setDex(int dex) {
    this.dex = dex;
}

public void setCon(int con) {
    this.con = con;
}

public void setInte(int inte) {
    this.inte = inte;
}

public void setSab(int sab) {
    this.sab = sab;
}

public void setCar(int car) {
    this.car = car;
}

public void setDef(int def) {
    this.def = def;
}

public void setpG(int pG) {
    this.pG = pG;
}

public void setGolpetazo(int golpetazo) {
    this.golpetazo = golpetazo;
}

public void setGolpetazoDanio(int golpetazoDanio) {
    this.golpetazoDanio = golpetazoDanio;
}
public void setPGActualesArm(int pGActualesArm){
    this.pGActualesArm = pGActualesArm;
}
    
}
