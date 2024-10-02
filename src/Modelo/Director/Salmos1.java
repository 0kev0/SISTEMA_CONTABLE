/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Director;

import java.util.ArrayList;
import java.util.Calendar;

public class Salmos1 {
    private ArrayList<String> salmos;

    public Salmos1() {
     salmos = new ArrayList<>();
     
    salmos.add("El Señor es mi pastor, nada me falta. - Salmo 23:1");
    salmos.add("El Señor es mi luz y mi salvación; ¿a quién temeré? - Salmo 27:1");
    salmos.add("Clama a mí y yo te responderé, y te enseñaré cosas grandes y ocultas que tú no conoces. - Jeremías 33:3");
    salmos.add("Jehová te bendiga, y te guarde; Jehová haga resplandecer su rostro sobre ti, y tenga de ti misericordia; Jehová alce sobre ti su rostro, y ponga en ti paz. - Números 6:24-26");
    salmos.add("El que habita al abrigo del Altísimo, morará bajo la sombra del Omnipotente. - Salmo 91:1");
    salmos.add("Fíate de Jehová de todo tu corazón, y no te apoyes en tu propia prudencia. - Proverbios 3:5");
    salmos.add("Aunque ande en valle de sombra de muerte, no temeré mal alguno, porque tú estarás conmigo; tu vara y tu cayado me infundirán aliento. - Salmo 23:4");
    salmos.add("Pacientemente esperé a Jehová, y se inclinó a mí, y oyó mi clamor. - Salmo 40:1");
    salmos.add("Jehová es mi fortaleza y mi escudo; en él confió mi corazón, y fui ayudado, por lo que se gozó mi corazón, y con mi cántico le alabaré. - Salmo 28:7");
    salmos.add("En paz me acostaré, y asimismo dormiré; porque solo tú, Jehová, me haces vivir confiado. - Salmo 4:8");
    salmos.add("Deléitate asimismo en Jehová, y él te concederá las peticiones de tu corazón. - Salmo 37:4");
    salmos.add("Alzaré mis ojos a los montes; ¿de dónde vendrá mi socorro? Mi socorro viene de Jehová, que hizo los cielos y la tierra. - Salmo 121:1-2");
    salmos.add("Crea en mí, oh Dios, un corazón limpio, y renueva un espíritu recto dentro de mí. - Salmo 51:10");
    salmos.add("El Señor está cerca de los quebrantados de corazón, y salva a los de espíritu abatido. - Salmo 34:18");
    salmos.add("Gustad, y ved que es bueno Jehová; dichoso el hombre que confía en él. - Salmo 34:8");
    salmos.add("Lámpara es a mis pies tu palabra, y lumbrera a mi camino. - Salmo 119:105");
    salmos.add("Bienaventurados los que guardan sus testimonios, y con todo el corazón le buscan. - Salmo 119:2");
    salmos.add("Bendice, alma mía, a Jehová, y bendiga todo mi ser su santo nombre. - Salmo 103:1");
    salmos.add("El que no ama, no ha conocido a Dios; porque Dios es amor. - 1 Juan 4:8");
    salmos.add("Encomienda a Jehová tu camino, y confía en él; y él hará. - Salmo 37:5");
    salmos.add("Este es el día que hizo Jehová; nos gozaremos y alegraremos en él. - Salmo 118:24");
    }

    public String getSalmoDelDia() {
        // Obtener el día del año
        Calendar calendar = Calendar.getInstance();
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        // Determinar el índice del Salmo basado en el día del año
        int index = dayOfYear % salmos.size();

        return salmos.get(index);
    }
}
