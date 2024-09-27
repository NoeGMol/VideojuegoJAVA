package paqueteJuegos;

import java.util.*;

public class App {
    public static void menuPrincipal(Scanner sc, List<Usuario> listaUsuarios){ //Metodo de Menu principal
        System.out.println("<<<<<<<<<<¡Bienvenid@ a la plataforma de Juegos!>>>>>>>>>>>");
        System.out.println("[1] Crear Usuario."); //Hago un menu para crear usuario, iniciar sesion o salir. Con un Scanner y luego un Switxh dependiendo de la opcion seleccionada.
        System.out.println("[2] Iniciar Sesión");
        System.out.println("[3] Salir.");
        int opcionMenu = sc.nextInt();
        sc.nextLine();
   
        switch (opcionMenu) {
            case 1:
                crearUsuario(sc, listaUsuarios); // Va al Metodo crearUsuario
                break;
            case 2:
                Usuario usuarioConectado = iniciarSesion(sc, listaUsuarios); // Compara la lista Usuarios con el usuario Conectado, si lo encuentra, lo lleva al Método menuJuegos, sino, lo vuelve al método Menu principal
                if(usuarioConectado != null){
                    menuJuegos(sc, listaUsuarios, usuarioConectado);
                } else {
                    System.out.println("El inicio de sesion no fue exitosio, por favor pruebe de nuevo");
                    menuPrincipal(sc, listaUsuarios);
                }
                break;

                case 3:
                System.out.println("Hasta la proxima!"); //Sale del programa
                System.exit(0);
                break;

                default:
                System.out.println("La opción ingresada no es válida"); //Por otra opcion, avisa la opcion invalida y retorna al Metodo menuPrincipal
                menuPrincipal(sc, listaUsuarios);
                break;
             
        }
    }

    public static void crearUsuario(Scanner sc, List<Usuario> listaUsuarios){ //Metodo para Crear un Usuario
        System.out.println("Ingrese su nombre de usuario:");
        String nombre = sc.nextLine(); //Toma el nombre de usuario ingresado

        System.out.println("Ingrese su contraseña");
        String contrasenia = sc.nextLine(); // Toma la contraseña ingresada

        listaUsuarios.add(new Usuario(nombre, contrasenia)); //Agrega a la lista de usuarios el nuevo objeto Usuario, con los parametros de Nombre y Contraseña

        System.out.println("Usuario creado exitosamente"); //AVisa la creacion exitosa del usuario
        menuPrincipal(sc, listaUsuarios); // Retorna al Método Menu Principal
    }

    public static Usuario iniciarSesion(Scanner sc, List<Usuario> listaUsuarios){ //Metodo para iniciar sesión, con return
        System.out.println("Nombre de Usuario:");// Ingresa nombre de usuario
        String nombre = sc.nextLine();

        System.out.println("Contraseña"); // ingresa contraseña
        String contrasenia = sc.nextLine();

        int pos = -1; 

        for(int i = 0; i < listaUsuarios.size(); i++){ // Compara el nombre de usuario ingresado en la listaUsuario, recorriendo la lista. Si lo encuentra, avisa por consola que lo halló, sino dirá usuario no encontrado y no retorna nada.
            listaUsuarios.get(i).getNombre().equals(nombre);
            if(listaUsuarios.get(i).getNombre().equals(nombre)){
                System.out.println("Usuario encontrado");
                pos = i;
            }
        }
if(pos == -1){
            System.out.println("Usuario no encontrado");
            return null;
        } else { 
            if(listaUsuarios.get(pos).getContrasenia().equals(contrasenia)){ // Compara el nombre de usuario ingresado en la listaUsuario, recorriendo la lista. Si lo encuentra, avisa por consola que lo halló, sino dirá usuario no encontrado y no retorna nada.
                System.out.println("Inicio de sesión exitoso");
                return listaUsuarios.get(pos);
            } else {
                System.out.println("Contraseña incorrecta");
                return null;
            }
        }
    }

    public static void menuJuegos(Scanner sc, List<Usuario> listaUsuarios, Usuario usuarioConectado){ // Menu para seleccionar el juego que queres probar. 
    
        System.out.println("[1] <<<<< STAR WARS: El juego de preguntas!>>>>>");
        System.out.println("[2] 'El tesoro perdido'");
        System.out.println("[3] Menú principal.");
        int opcionMenu = sc.nextInt();
        sc.nextLine();

        switch (opcionMenu) {
            case 1:
                juegoDePreguntas(sc, usuarioConectado, listaUsuarios); // Va al metodo juegoDePreguntas
                break;
            case 2:
                juegoDeRol(sc, usuarioConectado, listaUsuarios); // Va al método juegoDeRol
                break;
            case 3:
                menuPrincipal(sc, listaUsuarios);   //Vuelve al método menuPrincipal
                break;
            default:
                System.out.println("La opción ingresada es incorrecta");
                menuPrincipal(sc, listaUsuarios); //Vuelve al método menuPrincipal
                break;
        }
    }
    
    public static void juegoDePreguntas(Scanner sc, Usuario usuarioConectado, List<Usuario> listaUsuarios){ //Método para Juego de Preguntas
        int rta1, rta2, rta3, rta4, rta5, resuFinal;    // Declaro las variables
        System.out.println("Hace mucho tiempo en una galaxia muy, muy lejana");
        System.out.println("<<<<< STAR WARS: El juego de preguntas!>>>>>");
        System.out.println("[1] Iniciar partida."); // Con un switch se elije si iniciar un nuevo juego, volver al menu de seleccion de juegos o ver el Listado de Puntajes del usuario
        System.out.println("[2] Volver al Menú de Juegos.");
        System.out.println("[3] Listado de Puntajes.");
        Scanner scPreg = new Scanner(System.in);
        int menuPreg = scPreg.nextInt();
        switch (menuPreg) {
            case 1: 
                System.out.println("Vamos a poner a prueba tus conocimientos de la saga.");
                System.out.println("¡Hola " + usuarioConectado.getNombre() + "! ¿Estas listo? ¡Empecemos!"); // obtiene desde el Usuario el nombre para personalizar la experiencia
                System.out.println("--------------------------------------");
                System.out.println("1) ¿En que año se estrenó Star Wars?");
                System.out.println("[1] 1978");
                System.out.println("[2] 1977");
                System.out.println("[3] 1979");
                System.out.println("[4] 1980");
                Scanner r1 = new Scanner(System.in);
                rta1 = r1.nextInt();
                switch(rta1){
                    case 1:
                        System.out.println("La respuesta es incorrecta.");
                        rta1 = 0;
                        break;
                    case 2:
                        System.out.println("La respuesta es correcta.");
                        rta1 = 20; // Modifico el valor de la variable segun la respuesta sea correcta.
                        break;
                    case 3:
                        System.out.println("La respuesta es incorrecta.");
                        rta1 = 0;
                        break;
                    case 4:
                        System.out.println("La respuesta es incorrecta.");
                        rta1 = 0;
                        break;
                    default:
                        System.out.println("Incorrecto. Por favor, ingresa una respuesta válida.");
                        juegoDePreguntas(sc, usuarioConectado, listaUsuarios); //Vuelve al inicio del juego
                }
                System.out.println("--------------------------------------");
                System.out.println("2) ¿Como se llama el protagonista de la primera trilogía?");
                System.out.println("[1] Loke Starwalker");
                System.out.println("[2] Luke Starkiller");
                System.out.println("[3] Luca Stormtropper");
                System.out.println("[4] Luke Skywalker");
                Scanner r2 = new Scanner(System.in);
                    rta2 = r2.nextInt();
                switch(rta2){
                    case 1:
                        System.out.println("La respuesta es incorrecta.");
                        rta2 = 0;
                        break;
                    case 2:
                        System.out.println("La respuesta es incorrecta.");
                        rta2 = 0;
                        break;
                    case 3:
                        System.out.println("La respuesta es incorrecta.");
                        rta2 = 0;
                        break;
                    case 4:
                        System.out.println("La respuesta es correcta.");
                        rta2 = 20;
                        break;
                    default:
                        System.out.println("Incorrecto. Por favor, ingresa una respuesta válida.");
                        juegoDePreguntas(sc, usuarioConectado, listaUsuarios);
                }
                System.out.println("--------------------------------------");
                System.out.println("3) ¿En qué planeta vivía Luke con sus tíos?");
                System.out.println("[1] Tatooine");
                System.out.println("[2] Naboo");
                System.out.println("[3] Coruscant");
                System.out.println("[4] Mandalore");
                Scanner r3 = new Scanner(System.in);
                rta3 = r3.nextInt();
                switch(rta3){
                    case 1:
                        System.out.println("La respuesta es correcta.");
                        rta3 = 20;
                        break;
                    case 2:
                        System.out.println("La respuesta es incorrecta.");
                        rta3 = 0;
                        break;
                    case 3:
                        System.out.println("La respuesta es incorrecta.");
                        rta3 = 0;
                        break;
                    case 4:
                        System.out.println("La respuesta es incorrecta.");
                        rta3 = 0;
                        break;
                    default:
                        System.out.println("Incorrecto. Por favor, ingresa una respuesta válida.");
                        juegoDePreguntas(sc, usuarioConectado, listaUsuarios);
                }
                System.out.println("--------------------------------------");
                System.out.println("4) ¿Quien es la líder de la Alianza Rebelde?");
                System.out.println("[1] Padme Amidala");
                System.out.println("[2] Ahsoka Tano");
                System.out.println("[3] Asajj Ventress");
                System.out.println("[4] Leia Organa");
                Scanner r4 = new Scanner(System.in);
                rta4 = r4.nextInt();
                switch(rta4){
                    case 1:
                        System.out.println("La respuesta es incorrecta.");
                        rta4 = 0;
                        break;
                    case 2:
                        System.out.println("La respuesta es incorrecta.");
                        rta4 = 0;
                        break;
                    case 3:
                        System.out.println("La respuesta es incorrecta.");
                        rta4 = 0;
                        break;
                    case 4:
                        System.out.println("La respuesta es correcta.");
                        rta4 = 20;
                        break;
                    default:
                        System.out.println("Incorrecto. Por favor, ingresa una respuesta válida.");
                        juegoDePreguntas(sc, usuarioConectado, listaUsuarios);
                }
                System.out.println("--------------------------------------");
                System.out.println("5) ¿Como se llamaba el planeta donde se encontraba la base rebelde?");
                System.out.println("[1] Dantooine");
                System.out.println("[2] Tatooine");
                System.out.println("[3] Yavin IV");
                System.out.println("[4] Alderaan");
                Scanner r5 = new Scanner(System.in);
                rta5 = r5.nextInt();
                switch(rta5){
                    case 1:
                        System.out.println("La respuesta es incorrecta.");
                        rta5 = 0;
                        break;
                    case 2:
                        System.out.println("La respuesta es incorrecta.");
                        rta5 = 0;
                        break;
                    case 3:
                        System.out.println("La respuesta es correcta.");
                        rta5 = 20;
                        break;
                    case 4:
                        System.out.println("La respuesta es incorrecta.");
                        rta5 = 0;
                        break;
                    default:
                        System.out.println("Incorrecto. Por favor, ingresa una respuesta válida.");
                        juegoDePreguntas(sc, usuarioConectado, listaUsuarios);
                    }
                resuFinal = rta1 + rta2 + rta3 + rta4 + rta5; //Suma el resultado de cada respuesta y lo guarda el la variable resuFinal
                System.out.println("Tu puntaje final es " + resuFinal +"/100.¡Espero te hayas divertido!"); //Le indica al usuario el puntaje final
                usuarioConectado.setListaPuntajesPreguntas(new Puntajes(resuFinal)); // guarda en la lista de puntajes del juego Preguntas el resuFinal
                System.out.println("¡Muchas gracias por jugar!");
                juegoDePreguntas(sc, usuarioConectado, listaUsuarios); //Vuelve al inicio del juego
                break;
            case 2:
                menuJuegos(scPreg, listaUsuarios, usuarioConectado); // vuelve al menu de seleccion de juegos
                break;
            case 3:
                System.out.println("Tus puntajes registrados son: "); // Muestra todos los puntajes que tiene el usuario guardado en el juego, como un Score
                for(int i = 0; i < usuarioConectado.getListaPuntajesPreguntas().size(); i++) {   
                System.out.println(usuarioConectado.getListaPuntajesPreguntas().get(i).getPuntajeFinal());
                }  
                juegoDePreguntas(scPreg, usuarioConectado, listaUsuarios); //Vuelve al inicio del juego
                break;
            }
        }
    private static int tiradaBase6 =((int)(Math.random()*5+1)); 

    public static void tiradaD6(int tiradaBase6){ //metodo para realizar una tirada base, obteniendo un numero random entre 1 y 6
        System.out.println(tiradaBase6);
    }   

    public static void peleaAtaque(Scanner sc, Usuario usuarioConectado, List<Usuario>listaUsuarios, CharyMonstruos personajePrincipal, Monstruos armaduraAnimada, int tiempo){ // metodo para implementar la pelea en el juegoDeRol
        System.out.println("Preparate para Atacar. Tiraremos un dado de 20 caras (D20): ");
        int tiradaBase20 =((int)(Math.random()*20+1)); //obtiene un numero random entre 1 y 20
        int resuTiradaAt = tiradaBase20; // guarda en la variable el resultado del random
        System.out.println("Tu resultado es "+resuTiradaAt); // muestra por consola el resultado del random
        int bonifFuer = personajePrincipal.getmainFue(); //guarda en la variable el bonificador de fuerza del personaje principal
        int boifArmPDef = armaduraAnimada.getdef(); // guarda en la variable la defensa del enemigo
        int bonifConst = armaduraAnimada.getcon(); // guarda en la variable el bonificador de Constitucion del enemigo
        System.out.println("Agrega "+ bonifFuer + " de tu Fuerza al resultado de la tirada"); //avisa x consola que se suma el bonificador al numero random
        System.out.println("La Armadura tiene " + boifArmPDef + " + " + bonifConst + " puntos de defensa totales"); // avisa por consola la cantidad de puntos de defensa que tiene el enemigo
        if(resuTiradaAt+bonifFuer>boifArmPDef+bonifConst){ //Si el resultado del random + la fuerza del personaje es mayor a la defensa y constitucion del enemigo, se logra lastimar al enemigo y hace un random por el daño
            System.out.println("¡Lograste lastimar a la Armadura!, Ahora tira el dado de daño (D6):");
            tiradaD6(tiradaBase6); //tomo el metodo para tirada base D6
            int danioRealizado = tiradaBase6; //guardo el resultado en la variable danioRealizado
            int bonifDanio = personajePrincipal.getmainPDanio(); // obtengo los bonificadores para el daño
            int totalDanio = danioRealizado+bonifDanio; // guardo el resultado de la variable de daño sumando el resultado de la tirada con el bonificador de daño
            int vidaArmadura = armaduraAnimada.getpGActualesArm(); //obtengo la vida actual del enemigo
            armaduraAnimada.setPGActualesArm(vidaArmadura-totalDanio); // actualizo la vida del enemigo restando el resultado del daño
            System.out.println("Hiciste "+ danioRealizado + " + " + bonifDanio + " = " + totalDanio + " puntos de daño a la Armadura. Actualmente su vida es de " + armaduraAnimada.getpGActualesArm()); // informo al usuario por consola el calculo realizado y la vida que tiene el enemigo
        } else if(personajePrincipal.getpGActualesPers()>0 & armaduraAnimada.getpGActualesArm()==0){ //si el daño hecho hace que la vida del enemigo llegue a 0 y nuestra vida es mayor a 0, derrotamos al enemigo
            System.out.println("¡Venciste a la Armadura! Tus puntos de vida actuales son "+personajePrincipal.getpGActualesPers());
            System.out.println("Gracias a esto, agregas 5 hs a tu contador de tiempo.");
            tiempo = tiempo+5;  // se agregan 5 a la variable tiempo
            System.out.println("Te quedan " + tiempo + " Hs para cumplir tu misión."); // avisa cuanto tiempo tiene acumulado
            System.out.println("-----------------------------------------------------------------------");
            } 
            else {System.out.println("Tu fuerza no consigue lastimar a la Armadura");  //si el resultado del random + la fuerza del personaje es menor a la defensa y constitucion del enemigo, avisa que no se pudo dañar al enemigo
        }
        System.out.println("Ahora es turno de la Armadura, prepárate. Tirará un dado de Golpe (D20):");
        int tiradaBase201 =((int)(Math.random()*20+1)); //obtiene un numero random entre 1 y 20
        int resTiradaAt = tiradaBase201; // guarda en la variable el resultado del random
        System.out.println("La tirada de la Armadura es "+resTiradaAt); // muestra por consola el resultado del random
        int boniFuer = armaduraAnimada.getfuer(); //guarda en la variable el bonificador de fuerza del enemigo
        int bonifcharPDef = personajePrincipal.getmainPDef(); // guarda en la variable la defensa del personaje principal
        int boniConst = personajePrincipal.getmainCon(); // guarda en la variable el bonificador de Constitucion del personaje principal
        System.out.println("La Armadura agrega "+ boniFuer + " puntos de Fuerza al resultado de la tirada"); //avisa x consola que se suma el bonificador al numero random
        System.out.println("Tienes " + bonifcharPDef + " + " + boniConst + " puntos de Defensa totales."); // avisa por consola la cantidad de puntos de defensa que tiene el personaje principal
        if(resTiradaAt+boniFuer>bonifcharPDef+boniConst){ //Si el resultado del random + la fuerza del enemigo es mayor a la defensa y constitucion del personaje principal, se logra lastimar al personaje y hace un random por el daño
            System.out.println("¡La Armadura ha logrado dañarte!, Ahora tirará el daño:");
            tiradaD6(tiradaBase6); //tomo el metodo para tirada base D6
            int danioRealizado = tiradaBase6; //guardo el resultado en la variable danioRealizado
            int bonifDanio = armaduraAnimada.getgolpetazo(); // obtengo los bonificadores para el daño
            int totalDanio = danioRealizado+bonifDanio; // guardo el resultado de la variable de daño sumando el resultado de la tirada con el bonificador de daño
            int vidaChar = personajePrincipal.getpGActualesPers(); //obtengo la vida actual del personaje principal
            personajePrincipal.setPGActualesPers(vidaChar-totalDanio);// actualizo la vida del personaje principal restando el resultado del daño
            System.out.println("Te hizo "+ danioRealizado + " + " + bonifDanio + " = " + totalDanio + " puntos de daño. Actualmente tu vida es de " + personajePrincipal.getpGActualesPers()); // informo al usuario por consola el calculo realizado y la vida que tiene el personaje principial
        } else {
            System.out.println("Su fuerza no consigue lastimarte");} //si el resultado del random + la fuerza del enemigo es menor a la defensa y constitucion del personaje, avisa que no se pudo dañar
            if(personajePrincipal.getpGActualesPers()<1 & armaduraAnimada.getpGActualesArm()>0){ //si el daño hecho hace que la vida del personaje llegue a 0 y la vida del enemigo es mayor a 0, nos derroto.
                System.out.println("La Armadura te ha matado. FIN");
                juegoDeRol(sc, usuarioConectado, listaUsuarios); // retorna al método juegoDeRol
            } else {}
        System.out.println("¿Continuas atacando o intentas huir?:");
        System.out.println("[1] Atacas");
        System.out.println("[2] Huyes");
        Scanner scnr4 = new Scanner(System.in); // por un Scanner se determina si continua atacando o intenta huir
        int resp5 = scnr4.nextInt();
        switch (resp5) {
            case 1:
                peleaAtaque(scnr4, usuarioConectado, listaUsuarios, personajePrincipal, armaduraAnimada, tiempo);  // retorna al metodo peleaAtaque
                break;
            case 2:
                System.out.println("Intentas evadir los ataques y correr con todas tus fuerzas. Haz una tirada con un D20, sumando la destreza e inteligencia respectivameente: " + personajePrincipal.getmainDex()+ " + " + personajePrincipal.getmainInt());
                tiradaD20(tiradaBase20);
                int tiradaD20huir = tiradaBase20;
                int resuTiradaHuir = tiradaD20huir + personajePrincipal.getmainDex() + personajePrincipal.getmainInt(); // hace un random sumando la destreza e inteligencia para intentar huir
                System.out.println("Tu resultado es " + resuTiradaHuir);
                if(resuTiradaHuir>=10){ //si es igual o mayor a 10, logras huir
                    System.out.println("¡Lograste escapar del combate! Rapidamente continuas el camino, pero esto te costó 1 hr de tiempo");
                    tiempo = tiempo-1+personajePrincipal.getbrujula();
                    System.out.println("Te quedan " + tiempo + " Hs para cumplir tu misión.");
                    System.out.println("-----------------------------------------------------------------------");}
                else {{System.out.println("No lograste escapar, continúa el combate"); // si es menor a 10, no logras huir y se repite el metodo peleaAtaque
                    peleaAtaque(scnr4, usuarioConectado, listaUsuarios, personajePrincipal, armaduraAnimada, tiempo);}}
                break;
            default:
                System.out.println("Respuesta incorrecta.");
                juegoDeRol(scnr4, usuarioConectado, listaUsuarios);
                break;
        }
    }



    public static void salidaTemplo(int tiempo, CharyMonstruos personajePrincipal, Scanner sc, Usuario usuarioConectado, List<Usuario> listaUsuarios ){ //Metodo para las tiradas para intentar salir del templo
        tiempo=personajePrincipal.getTiempoTotal(); //obtiene el tiempo total actual
        int tiradaBase20 =((int)(Math.random()*20+1)); // hace un random entre 1 y 20
        int resuSalaTesoro = tiradaBase20+personajePrincipal.getmainDex(); // guarda ese resultado y suma el bonificador de Destreza
        System.out.println("Tu resultado total es " + resuSalaTesoro); //muestra el resultado
        if (resuSalaTesoro>=10){System.out.println("Pudiste avanzar sin problemas, agregas 1 Hr a tu contador de tiempo."); //si el resultado es igual o mayor a 10, logras avanzar
            tiempo=tiempo+1; //sumas 1 hr a tu tiempo
            personajePrincipal.setTiempoTotal(tiempo); // actualiza la variable tiempo con el setter del objeto personajePrincipal
        } else {
            System.out.println("No logras avanzar rápidamente. Pierdes 1 hr"); //Si no resulta, pierde una hora en variable tiempo
            tiempo=tiempo-1+personajePrincipal.getbrujula();} // actualiza la variable tiempo con el setter del objeto personajePrincipal, y suma si el personaje tiene valor en la variable brujula
            personajePrincipal.setTiempoTotal(tiempo);// actualiza la variable tiempo con el setter del objeto personajePrincipal
            if(personajePrincipal.getTiempoTotal()==0){System.out.println("Te quedaste sin tiempo. Ya no hay retorno. FIN"); //Si la variable tiempo llega a 0, pierde 
                juegoDeRol(sc, usuarioConectado, listaUsuarios);} // y sale al menu del juego
                System.out.println("Te quedan " + personajePrincipal.getTiempoTotal() + " Hs para cumplir tu misión."); // notifica cuantas horas  tiene el personaje acumuladas
                System.out.println("-----------------------------------------------------------------------");
    }
    
    private static int tiradaBase20 =((int)(Math.random()*20+1));

    public static void tiradaD20(int tiradaBase20){ // metodo para nro random entre 1 y 20
        System.out.println(tiradaBase20);
    }

    public static void juegoDeRol(Scanner sc, Usuario usuarioConectado, List<Usuario> listaUsuarios){ // metodo de juego de rol
        int tiempo = 10; //declaro las variables y asigno 10 al tiempo inicial
        int tomarDex;
        CharyMonstruos personajePrincipal = new CharyMonstruos(2, 2, 1, 3, 4, 2, 14, 50, 2, 0, 0, 50,10); // creo el objeto personajePrincipal y asigno sus variables
        Monstruos armaduraAnimada = new Monstruos(2, 0, 1, -5, -4, -5, 18, 33, 4, 7,33); // creo el objeto armaduraAnimada y asigno sus variables
        System.out.println("<<<<<< El Tesoro Perdido >>>>>>"); // menu del juego
        System.out.println("[1] Iniciar partida."); 
        System.out.println("[2] Volver al Menú de Juegos.");
        System.out.println("[3] Listado de Puntajes.");
        Scanner scnMenu = new Scanner(System.in);
        int respJuego = scnMenu.nextInt(); //por un switch, inicio los casos aguardando la rta del usuario
        switch (respJuego) {
            case 1:
                System.out.println("¡Hola " + usuarioConectado.getNombre() + "! ¿Estas listo? ¡Empecemos!"); // sumo el nombre de usuario para personalizar la experiencia
                System.out.println("Es el año 1898. En Buenos Aires, más precisamente entre las filas perdidas de los estantes húmedos y oscuros de la biblioteca de la Facultad de Medicina, te encuentras bajo la tenue iluminación de un farol. Nunca te habías adentrado en estas secciones olvidadas, pero tu urgencia es más poderosa que cualquier temor. Precisas una solución, una cura para tu Padre, que yace enfermo hace semanas, sin que tu amada ciencia logre dilucidar qué mal le aqueja. El tiempo es tu mayor enemigo, y al descartar toda posibilidad que la ciencia podía brindarte, te sumerges a explorar las fuentes, la homeopatía o cualquier respuesta que mantenga tu esperanza firme, tenue como la luz de tu farol. Pero cuando tus esperanzas se habían casi consumido, entre las páginas de un viejo libro mohoso, un texto escrito en los tiempos de la conquista, por un autor que ya ni el tiempo recuerda, te inunda de fuerzas y coraje que tanto anhelabas: una flor, “la dorada”, que promete quitar cualquier mal y restablecer la salud hasta a quien penda del hilo de la vida y la muerte. Esta flor se encuentra en la antigua ciudad de El Dorado, que vió caer a exploradores en desgracia y desperdiciar su vida, y temes que tu destino se una a ellos. Pero no permites que eso te detenga, no es momento para dudas. Debes embarcarte en esta misión cuanto antes.");
                System.out.println("Debes hacerte de tu equipo, eliges:");
                System.out.println("[1] Llevar el mapa rudimentario en el libro.");
                System.out.println("[2] Tomas tus ahorros, para las provisiones.");
                System.out.println("[3] Corres hacia el primer barco que saldra, no hay tiempo para perder.");
                Scanner sc1 = new Scanner(System.in);
                int resp = sc1.nextInt(); //por un switch, inicio los casos aguardando la rta del usuario
                
                switch (resp) {
                    case 1:
                        System.out.println("Tomas el mapa, te será útil para lo desconocido. - Obtienes un +1 en tiradas de inteligencia -");
                        personajePrincipal.setMainInt(4);//sumar +1 a inteligencia del personaje con el setter         
                        break;
                    case 2:
                        System.out.println("Las provisiones incluyen una lámpara, soga, y un machete - Obtienes un +4 a las tiradas de daño -");
                        personajePrincipal.setMainDanioEsp(6); // agrego el machete que da +6 al daño
                        personajePrincipal.setMainPDanio(6);
                        //Sumar +4 al daño del personaje con el setter
                        break;
                    case 3:
                        System.out.println("Algo que no te sobra es tiempo, por lo que correr es vital para que el tiempo no apremie - Obtienes +4 hs a favor -");
                        tiempo = tiempo+4; //sumar 4 hs al contador de tiempo
                        break;
                    default:
                        System.out.println("Respuesta inválida.");
                        juegoDeRol(sc, usuarioConectado, listaUsuarios); //retorna al menu del juego si la rta no es la indicada en los case
                        break;
                }
                System.out.println("Tu llegada a la selva llevó bastante tiempo, y tiempo es lo ultimo que tienes ahora. Si querés salir exitoso de esta misión, tendras que tener mucho cuidado, porque el tiempo estará en tu contra.");
                System.out.println("Y como el tiempo corre, sabes que tenes 10 horas para entrar al templo y salir con el artefacto.");
                System.out.println("Te quedan " + tiempo + " Hs para cumplir tu misión.");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("'La Entrada mística'");
                System.out.println("Frente a tus ojos se extiende un arco que envuelve las vistas de la ciudad. Visibilizas dos formas de adentrarte, por el pasillo central o los callejones laterales.");
                System.out.println("[1] Decides adentrarte en la ciudad por el pasillo central");
                System.out.println("[2] Optas por investigar los callejones laterales, pensando que podrías encontrar atajos");
                Scanner scnr = new Scanner(System.in);
                int resp1 = scnr.nextInt(); //por un switch, inicio los casos aguardando la rta del usuario

                switch (resp1) {
                    case 1:
                        System.out.println("El pasillo central es el camino más directo, te lleva un tiempo recorrerlo. Todo esta derroído, oxidado. Los últimos remanentes de una gran civilización");// no se suman ni restan horas                    
                        break;
                    case 2:
                        System.out.println("Tu búsqueda no obtuvo buenos resultados. Estuviste buscando atajos en vano. Pierdes 2 horas. A pesar de esto, encontraste una rudimentaria brújula, tal vez de un explorador inexperto. 'la brujula te ayuda a perder menos tiempo (+1hr) si te perdés en el futuro'");
                        tiempo = tiempo-2;
                        personajePrincipal.setBrujula(1);//sumar brujula a personaje +1 con el setter
                        break;
                    default:
                        System.out.println("Respuesta incorrecta.");
                        juegoDeRol(sc, usuarioConectado, listaUsuarios); //retorna al menu del juego si la rta no es la indicada en los case
                        break;
                }
                System.out.println("Te quedan " + tiempo + " Hs para cumplir tu misión."); // muestra por consola el tiempo que queda
                System.out.println("-----------------------------------------------------------------------");
                if(tiempo==0){System.out.println("Te quedaste sin tiempo. Ya no hay retorno. FIN"); // si el tiempo llega a 0, termina el juego y vuelve al menu Juegode Rol
                    juegoDeRol(scnr, usuarioConectado, listaUsuarios);
                    }
                System.out.println("'El Cruce de Caminos'");
                System.out.println("Encuentras un antiguo puente colgante. ¿Lo cruzas o buscas otro camino?");
                System.out.println("[1] Cruzo por el puente colgante");
                System.out.println("[2] Busco otro camino, el puente se ve demasiado frágil");
                Scanner scnr2 = new Scanner(System.in);
                int resp2 = scnr2.nextInt(); //por un switch, inicio los casos aguardando la rta del usuario

                switch (resp2) {
                    case 1:
                        tiradaD20(tiradaBase20); // metodo para nro random entre 1 y 20
                        tomarDex = personajePrincipal.getmainDex(); // obtengo la destreza
                        System.out.println("Agrega + " + tomarDex + " al resultado de la tirada (Suma Destreza)");
                            if(tiradaBase20+tomarDex>=10){ 
                                System.out.println("Tomas coraje, respiras hondo y con tus fuerzas, cruzas hábilmente entre las tablas derruidas. Algunas se desprenden al pisar, pero rapidamente recuperas la marcha. Con nervios, pero aprisa, tus pies llegan al otro lado. Tu valentía cobró frutos, esto definitivamente te dará tiempo extra. 'Agregas 1 hr al tiempo'");
                                tiempo = tiempo+1;
                            } else {
                                System.out.println("Intentas sostenerte entre las tablas, pero estas estan muy dañadas. Tu pie se hunde en el vacío, y tus manos no son lo suficiemente rápidas para sostenerte a tiempo. Con un grito ahogado que retumba en las paredes del antiguo templo, te hundes en la profundidad del vacío. Este lugar se convirtió en tu tumba. FIN");
                                juegoDeRol(sc, usuarioConectado, listaUsuarios); 
                            }
                        // Cruzas, hace tirada de destreza porque es un puente viejo. Si superas, pasas y sumas 1 hora, sino caes al vacio Game over.                    
                        break;
                    case 2:
                        System.out.println("Descubres un túnel oscuro que parece llevar directo al corazón de la ciudad. Te atrasas 2 hs"); //restar si hay bonificador brujula
                        tiempo = (tiempo-2)+personajePrincipal.getbrujula();
                        break;
                    default:
                        System.out.println("Respuesta incorrecta. volver a ingresar");
                        juegoDeRol(sc, usuarioConectado, listaUsuarios); //retorna al menu del juego si la rta no es la indicada en los case
                        break;
                }   
                System.out.println("Te quedan " + tiempo + " Hs para cumplir tu misión."); // muestra por consola el tiempo que queda
                System.out.println("-----------------------------------------------------------------------");
                if(tiempo==0){System.out.println("Te quedaste sin tiempo. Ya no hay retorno. FIN");// si el tiempo llega a 0, termina el juego y vuelve al menu Juegode Rol
                    juegoDeRol(scnr2, usuarioConectado, listaUsuarios);
                }
                System.out.println("'La Armadura Animada'");
                System.out.println("Retomas el camino que viene demarcado, pero unos ruidos te llaman la atencion más adelante. Una figura alta, con una espada, proteje el camino. Rapidamente deberás decidir que hacer: ");
                System.out.println("[1] Te enfrentas a la Armadura gigante que bloquean el camino");
                System.out.println("[2] Intentas rodear la Armadura, evitando cualquier confrontación");
                Scanner scnr3 = new Scanner(System.in);
                int resp3 = scnr3.nextInt(); //por un switch, inicio los casos aguardando la rta del usuario

                switch (resp3) {
                    case 1:
                        System.out.println("Con valor, te preparas para pelear.");
                        System.out.println("Por la sorpresa, atacas primero:");
                        peleaAtaque(scnr3, usuarioConectado, listaUsuarios, personajePrincipal, armaduraAnimada, tiempo); // inicializo el Metodo peleaAtaque
                        break;
                    case 2:
                        System.out.println("Intentas huir. Tiras un dado D20, sumando destreza e inteligencia. Debes ser muy sigiloso. Tenes que superar una dificultad de 12");
                        tiradaD20(tiradaBase20); // metodo para nro random entre 1 y 20
                        int resuDexInt = tiradaBase20+personajePrincipal.getmainDex()+personajePrincipal.getmainInt();  //guardo el resultado con los bonificadores
                        System.out.println("Tu tirada es de " + tiradaBase20 + " + " + personajePrincipal.getmainDex() + " + " + personajePrincipal.getmainInt()); //muestro el resultado con los bonificadores
                        if (resuDexInt >=12){ //Si el resultado es mayor o igual a 12, se resta una hora de tiempo pero se suma si tiene brujula
                            System.out.println("Con cuidado, pasas por detras de unas columnas derruidas, casi imperceptible. Por momentos debes ocultarte y esperar, ya que la Armadura esta atenta. Esto te lleva tiempo. Resta -2 hr a tu contador de tiempo.");
                            tiempo = tiempo-1+personajePrincipal.getbrujula();
                            System.out.println("Te quedan " + tiempo + " Hs para cumplir tu misión."); // muestra por consola el tiempo que queda
                            System.out.println("-----------------------------------------------------------------------");
                        } else {
                            System.out.println("¡La Armadura te ha detectado!"); //Si es menor se inicia o vuelve la pelea. llama al metodo peleaAtaque
                            peleaAtaque(scnr3, usuarioConectado, listaUsuarios, personajePrincipal, armaduraAnimada, tiempo);}
                        break;
                        default:
                            System.out.println("Respuesta invalida. Ingrese una respuesta válida.");
                            juegoDeRol(sc, usuarioConectado, listaUsuarios); //retorna al metodo menu del juego si la rta no es la indicada en los case
                        break;
                }
                if(tiempo==0){System.out.println("Te quedaste sin tiempo. Ya no hay retorno. FIN");
                    juegoDeRol(scnr3, usuarioConectado, listaUsuarios); // si el tiempo llega a 0, termina el juego y vuelve al menu Juegode Rol
                }
                System.out.println("'El Templo Principal'");
                System.out.println("Te estas extenuando, cada paso que das es más pesado, pero tu determinación sigue intacta. Continuas avanzando, hasta encontrar el Templo: un lugar sagrado que ni el paso del tiempo pudo desdeñar su belleza. Ante tu vista se abre una puerta principal, llena de ornamentos. También podrias elegir buscar otra alternativa:");
                System.out.println("[1] Abres las puertas principales del Templo");
                System.out.println("[2] Buscas un camino alternativo para pasar.");
                Scanner scnr4 = new Scanner(System.in);
                int resp4 = scnr4.nextInt(); // lee la rta ingresada por consola
                switch (resp4) {
                    case 1:
                        System.out.println("Las puertas son pesadas, estan hechas para no permitir que nadie ingrese, sólo los mas penitentes del dios a quien adoraban. Para poder descifrarlo, deberas utilizar tu inteligencia, tal vez en los escritos haya una pista que te facilite poder abrirlas.");
                        System.out.println("Haremos una tirada de D20 + tu bonificador de inteligencia que es " + personajePrincipal.getmainDex());
                        tiradaD20(tiradaBase20); //hace un random de 1 a 20
                        int tiradaD20Int = tiradaBase20+personajePrincipal.getmainDex();
                        System.out.println("Has obtenido " + tiradaD20Int + " en total de tu tirada");
                        if(tiradaD20Int>=12){System.out.println("Luego de escudriñar los relieves, te das cuenta que moviendo una serie de ellos, desbloquea la puerta. Ganaste 1 hr de tiempo");
                            tiempo = tiempo+1; //si la tirada es mayot o igual a 12 se supera y agrega 1 hr al contador de tiempo
                        } else if(personajePrincipal.getmainDanioEsp()>0){System.out.println("Tu cerebro parece explotar mirando, observando los detalles, pero nada tiene sentido para ti. Luego de mucho tiempo, consideras que tal vez tu machete hará hará el trabajo. Empiezas a destruir la puerta de madera de a poco, hasta que logras hacer un hueco donde puedes pasar. Pierdes 2 hs de tiempo."); //si el jugador obtuvo el machete, se le restan solo 2 hs del contador de tiempo
                                tiempo = tiempo-2+personajePrincipal.getbrujula();}  
                            else {
                                System.out.println("Tu cerebro parece explotar mirando, observando los detalles, pero nada tiene sentido para ti. Luego de mucho tiempo, consideras que tal vez un escombro hará hará el trabajo. Empiezas a destruir la puerta de madera de a poco, hasta que logras hacer un hueco donde puedes pasar. Pierdes 4 hs de tiempo.");
                                tiempo = tiempo-4+personajePrincipal.getbrujula(); // si no tengo el machete, resto 4 hs de tiempo
                            }
                        break;
                    case 2:
                        System.out.println("Rodeas el templo. Un hueco, del tamaño que pasaría una cabra, se abre en las paredes, pero parece haber luz en el fondo. Avanzas con cautela, cuidando cada paso. En un momento la luz se abre ante ti. Visualizas la salida y apuras el paso. Saliste al centro del mismo, ya te encuentras en lo que parece el corazón del Templo. - Ganas 3 Hs de tiempo - ");
                        tiempo = tiempo+3; //suma 3 hs al tiempo
                        break;
                    default:
                    System.out.println("Respuesta incorrecta. volver a ingresar");
                    juegoDeRol(scnr4, usuarioConectado, listaUsuarios);  //retorna al menu del juego si la rta no es la indicada en los case   
                    break;
                }
                if(tiempo==0){System.out.println("Te quedaste sin tiempo. Ya no hay retorno. FIN");
                    juegoDeRol(scnr4, usuarioConectado, listaUsuarios); // si el tiempo llega a 0, termina el juego y vuelve al metodo menu Juegode Rol
                }
                System.out.println("Te quedan " + tiempo + " Hs para cumplir tu misión.");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("La Sala del Tesoro");
                System.out.println("Y por fin, ante ti el salón inmenso que a pesar de que los años hayan pasado, su esplendor se cierne, te invade. Las paredes vibran con un tenue color oro, que capta la leve luz que ingresa en la gran bóveda. En el medio, se eleva un altar, y un fruto impoluto, más brillante que todo el resto, sobre el final del pilar. Tus pies se mueven solos hacia la fruta, hasta tenerla al alcance de la mano. Entonces: ");
                System.out.println("[1] Observas cautelosamente el tesoro antes de tocarlo.");
                System.out.println("[2] Te lanzas a recoger el tesoro sin miramientos.");
                Scanner scnr6 = new Scanner(System.in);
                int resp6 = scnr6.nextInt();
                switch (resp6) {
                    case 1:
                        System.out.println("Tu mirada recorre los garabatos. Presentis que algo se oculta entre ellos. - Hace una tirada de D20 + tu modificador de Sabiduría ( "+ personajePrincipal.getmainSab() +"). La dificultad a superar es 15.");
                        tiradaD20(tiradaBase20);
                        int resuTiradaSab = tiradaBase20+personajePrincipal.getmainSab();
                        System.out.println("El resultado es "+ resuTiradaSab );
                        if (resuTiradaSab>=15){ //si la tirada es igual o mayor a 15, sale ok y obtiene el tesoro
                            System.out.println("Por los símbolos tallados en el altar, te das cuenta que, si queres retirar la fruta, debes levantarla realizando un circulo con la base, en el sentido de la salida y puesta de sol. El ritual debe completarse, respetando exactamente las instrucciones. Con respeto, sigues los mandatos al pie de la letra. Terminas el ritual y con mucho cuidado acuñas entre tus manos el tesoro que te tomo tanto obtener. - ¡Encontraste el tesoro! -");
                        } else if (resuTiradaSab<15){ //si el resultado es menor a 15, hace un random ente 1 y 20 con la destreza, con dificultad de 12. Si es exitoso, obtienes el tesoro, sino se restan 10 puntos de vida por la trampa.
                                System.out.println("No comprendes muy bien los garabatos tallados en el pilar. Pero necesitas la fruta, toda tu travesía se basa en esto. Sin titubeos, tomas la fruta. Casi inmediatamente, unas cuchillas se elevan con rapidez desde la base del altar. Hace una tirada de D20 + Tu bonificador de Destreza, que es " + personajePrincipal.getmainDex());
                                tiradaD20(tiradaBase20);
                                int tiradaDex = tiradaBase20+personajePrincipal.getmainDex();
                                System.out.println("Tu resultado es " + tiradaDex);
                            if (tiradaDex>=12){System.out.println("Con rapidez, apartas tus manos y cuerpo del altar. De pronto todo comienza a temblar. El altar se deshace en pedazos, al igual que varias columnas del templo, debes apurarte a salir, ya no es seguro.");}
                            else if (tiradaDex<12){System.out.println("Tus reflejos no fueron suficientemente rápidos. - Recibes 10 puntos de daño a tus manos y pies, y reduces tu movilidad a -2hs de tiempo");
                                tiempo=tiempo-2+personajePrincipal.getbrujula();
                                int vidaActual = personajePrincipal.getpGActualesPers();
                                int resuVida = vidaActual-10;
                                personajePrincipal.setPGActualesPers(resuVida);  //se actualizan los PG Actuales del personaje con el setter                                              
                            }
                        }                   
                        break;
                    case 2:
                        System.out.println("No comprendes muy bien los garabatos tallados en el pilar. Pero necesitas la fruta, toda tu travesía se basa en esto. Sin titubeos, tomas la fruta. Casi inmediatamente, unas cuchillas se elevan con rapidez desde la base del altar. Hace una tirada de D20 + Tu bonificador de Destreza, que es " + personajePrincipal.getmainDex());
                        tiradaD20(tiradaBase20);//hace un random ente 1 y 20 con la destreza, con dificultad de 12. Si es exitoso, obtienes el tesoro, sino se restan 10 puntos de vida por la trampa.
                        int tiradaDex = tiradaBase20+personajePrincipal.getmainDex();
                        System.out.println("Tu resultado es " + tiradaDex);
                        if (tiradaDex>=12){System.out.println("Con rapidez, apartas tus manos y cuerpo del altar. De pronto todo comienza a temblar. El altar se deshace en pedazos, al igual que varias columnas del templo, debes apurarte a salir, ya no es seguro.");}
                        else if (tiradaDex<12){System.out.println("Tus reflejos no fueron suficientemente rápidos. - Recibes 10 puntos de daño a tus manos y pies, y reduces tu movilidad a -2hs de tiempo");
                            tiempo=tiempo-2+personajePrincipal.getbrujula();
                            int vidaActual = personajePrincipal.getpGActualesPers();
                            int resuVida = vidaActual-10;
                            personajePrincipal.setPGActualesPers(resuVida);
                            } 
                        break;                
                    default:
                        System.out.println("Respuesta incorrecta. volver a ingresar");
                        juegoDeRol(scnr4, usuarioConectado, listaUsuarios);  //retorna al menu del juego si la rta no es la indicada en los case   
                        break;
                }
                if(tiempo==0){System.out.println("Te quedaste sin tiempo. Ya no hay retorno. FIN");
                    juegoDeRol(scnr6, usuarioConectado, listaUsuarios);} // si el tiempo llega a 0, termina el juego y vuelve al metodo menu Juegode Rol
                if(personajePrincipal.getpGActualesPers()==0){System.out.println("Sientes tu salud debilitarse, y las heridas son muy grandes, te desvaneces en el frio templo. FIN ");
                    juegoDeRol(scnr6, usuarioConectado, listaUsuarios);} // si la vida del personaje llega a 0
                System.out.println("Te quedan " + tiempo + " Hs para cumplir tu misión."); 
                personajePrincipal.setTiempoTotal(tiempo);
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("'La Salida'");
                System.out.println("Con celeridad, e intentando salir con rapidez, debes realizar 5 tiradas de D20, una por cada desafío superado. Tu destreza (" + personajePrincipal.getmainDex() + ") será la que ayude a superar todos los obstaculos, de lo contrario, este templo será tu fin.");
                System.out.println("Cada fallo, te retrasará la salida por 1 hr, pero cada éxito te sumará 1 hr de tiempo.");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("'La Sala del Tesoro'. Debes superar a 10 para tener éxito.");
                salidaTemplo(tiempo, personajePrincipal, scnr6, usuarioConectado, listaUsuarios); //llamo al metodo salidaTemplo por cada instancia
                System.out.println("'El Templo Principal'. Debes superar a 10 para tener éxito.");
                salidaTemplo(tiempo, personajePrincipal, scnr6, usuarioConectado, listaUsuarios);
                System.out.println("'La Armadura Animada'. Debes superar a 10 para tener éxito.");
                salidaTemplo(tiempo, personajePrincipal, scnr6, usuarioConectado, listaUsuarios);
                System.out.println("'El Cruce de Caminos'. Debes superar a 10 para tener éxito.");
                salidaTemplo(tiempo, personajePrincipal, scnr6, usuarioConectado, listaUsuarios);
                System.out.println("'La Entrada mística'. Debes superar a 10 para tener éxito.");
                salidaTemplo(tiempo, personajePrincipal, scnr6, usuarioConectado, listaUsuarios);

                System.out.println("El desafío fue superado. Atrás dejaste los obstáculos, y triunfaste, a pesar de la adversidad. <<< Tu tiempo total es de "+ personajePrincipal.getTiempoTotal() + " Hr >>>. Ahora queda solo retornar a tu hogar, y salvar a tu Padre. Superaste el desafío del 'Templo Dorado'");
                int tiempoFinal = personajePrincipal.getTiempoTotal(); //actualizo el tiempo total del personaje con el resultado final
                usuarioConectado.setListaPuntajesRol(new Puntajes(tiempoFinal)); //agrego las horas como puntaje en el usuario que se encuentra conectado                              
                System.out.println("El Tiempo se guardará como tu Puntuación. Si quieres desafiar al Templo nuevamente, puedes intentar superarla.");
                System.out.println("[1] Volver a Jugar (Menu del Juego).");
                System.out.println("[2] Menú Principal.");
                Scanner scnr7 = new Scanner(System.in);
                int resp7 = scnr7.nextInt();
                switch (resp7) {
                    case 1:
                        App.juegoDeRol(scnr7, usuarioConectado, listaUsuarios); //vuelve al metodo juego de rol
                        break;
                    case 2:
                        menuPrincipal(scnr7, listaUsuarios); //vuelve al metodo menu principal
                    default:
                        System.out.println("Respuesta incorrecta. Retorna al Menu");
                        juegoDeRol(scnr7, usuarioConectado, listaUsuarios); //vuelve al metodo Juego de rol
                        break;
                }
            break;
            case 2:
                App.menuJuegos(scnMenu, listaUsuarios, usuarioConectado); //retorna al metodo menujuegos
                break;
            case 3:
                System.out.println("Tus puntajes registrados son: ");
                for(int i = 0; i < usuarioConectado.getListaPuntajesRol().size(); i++) {   
                    System.out.println(usuarioConectado.getListaPuntajesRol().get(i).getPuntajeFinal());
                }  //muestra en consola los puntos que hizo el usuario conectado
                juegoDeRol(sc, usuarioConectado, listaUsuarios); //retorna al metodo juegoDeRol
                break;
            default:
            System.out.println("Respuesta incorrecta. volver a ingresar");
            juegoDeRol(sc, usuarioConectado, listaUsuarios);  //retorna al menu del juego si la rta no es la indicada en los case   
            break;
            }
        }
        
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); //traigo el Scanner y la lista de usuarios que precisa el Menu Principal
        List<Usuario>listaUsuarios = new ArrayList<>();

        menuPrincipal(sc, listaUsuarios); //inicio el metodo Menu Principal en el mail
    }
}

