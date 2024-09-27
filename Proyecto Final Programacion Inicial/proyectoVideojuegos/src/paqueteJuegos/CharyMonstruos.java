package paqueteJuegos;

public class CharyMonstruos {
    private int mainFue;
    private int mainDex;
    private int mainCon;
    private int mainInt;
    private int mainSab;
    private int mainCar;
    private int mainPDef;
    private int mainPV;
    private int mainPDanio;
    private int mainDanioEsp;
    private int brujula;
    private int pGActualesPers;
    private int tiempoTotal;

        public CharyMonstruos(int mainFue, int mainDex, int mainCon, int mainInt, int mainSab, int mainCar, int mainPDef, int mainPV, int mainPDanio, int mainDanioEsp, int brujula, int pGActualesPers, int tiempoTotal){
            this.mainFue = mainFue;
            this.mainDex = mainDex;
            this.mainCon = mainCon;
            this.mainInt= mainInt;
            this.mainSab = mainSab;
            this.mainCar = mainCar;
            this.mainPDef = mainPDef;
            this.mainPV = mainPV;
            this.mainPDanio = mainPDanio;
            this.mainDanioEsp = mainDanioEsp;
            this.brujula = brujula;
            this.pGActualesPers = pGActualesPers;
            this.tiempoTotal = tiempoTotal;
        }

//Getters
public int getmainFue(){
    return mainFue;
}
public int getmainDex(){
    return mainDex;
}
public int getmainCon(){
    return mainCon;
}
public int getmainInt(){
    return mainInt;
}
public int getmainSab(){
    return mainSab;
}
public int getmainCar(){
    return mainCar;
}
public int getmainPDef(){
    return mainPDef;
}
public int getmainPV(){
    return mainPV;
}
public int getmainPDanio(){
    return mainPDanio;
}
public int getmainDanioEsp(){
    return mainDanioEsp;
}
public int getbrujula(){
    return brujula;
}
public int getpGActualesPers(){
    return pGActualesPers;
}
public int getTiempoTotal() {
    return tiempoTotal;
}

//Setters

public void setMainFue(int mainFue) {
    this.mainFue = mainFue;
}

public void setMainDex(int mainDex) {
    this.mainDex = mainDex;
}

public void setMainCon(int mainCon) {
    this.mainCon = mainCon;
}

public void setMainInt(int mainInt) {
    this.mainInt = mainInt;
}

public void setMainSab(int mainSab) {
    this.mainSab = mainSab;
}

public void setMainCar(int mainCar) {
    this.mainCar = mainCar;
}

public void setMainPDef(int mainPDef) {
    this.mainPDef = mainPDef;
}

public void setMainPV(int mainPV) {
    this.mainPV = mainPV;
}

public void setMainPDanio(int mainPDanio) {
    this.mainPDanio = mainPDanio;
}

public void setMainDanioEsp(int mainDanioEsp) {
    this.mainDanioEsp = mainDanioEsp;
}
public void setBrujula(int brujula){
    this.brujula = brujula;
}
public void setPGActualesPers(int pGActualesPers){
    this.pGActualesPers = pGActualesPers;
}
public void setTiempoTotal(int tiempoTotal) {
    this.tiempoTotal = tiempoTotal;
}

    
}
