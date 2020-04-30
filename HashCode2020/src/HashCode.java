public class HashCode {

    public static void main(String[] args) {

        Thread a = new MiHilo("a_example.txt");
        Thread b = new MiHilo("b_read_on.txt");
        Thread c = new MiHilo("c_incunabula.txt");
        Thread d = new MiHilo("d_tough_choices.txt");
        Thread e = new MiHilo("e_so_many_books.txt");
        Thread f = new MiHilo("f_libraries_of_the_world.txt");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
    }
}
