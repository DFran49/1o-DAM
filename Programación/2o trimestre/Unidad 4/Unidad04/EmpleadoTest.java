import org.junit.Test;

public class EmpleadoTest {
    @Test
    public void test1() {
        Empleado antonio = new Empleado("Antonio");
        Empleado juan = new Empleado("Juan");
        Empleado paco = new Empleado("Paco");
        Empleado alberto = new Empleado("Alberto");
        Empleado diego = new Empleado("Diego");
        Empleado rafa = new Empleado("Rafa");
        Empleado ricardo = new Empleado("Ricardo");
        Empleado patricia = new Empleado("Patricia");
        Empleado manuel = new Empleado("Manuel");
        Empleado mJose = new Empleado("María José");
        Empleado valentin = new Empleado("Valentín");
        Empleado gema = new Empleado("Gema");

        antonio.subordinado().add(juan);
            juan.subordinado().add(diego);
        antonio.subordinado().add(paco);
            paco.subordinado().add(rafa);
                rafa.subordinado().add(manuel);
                rafa.subordinado().add(mJose);
                    mJose.subordinado().add(valentin);
                    mJose.subordinado().add(gema);
            paco.subordinado().add(ricardo);
        antonio.subordinado().add(alberto);
            alberto.subordinado().add(patricia);

        antonio.mostrarSubordinados();

    }
}