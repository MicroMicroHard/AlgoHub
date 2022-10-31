package UnitTest.DataStructureTest.arrayAndListTest.listTest;

import DataStructure.list.Nodelj;
import org.junit.Test;

public class NodeljTest {

    Nodelj nodelj = new Nodelj();

    @Test
    public void testString2Nodelj() {
        Nodelj answer = nodelj.String2Nodelj("123");
        Nodelj first = new Nodelj(1);
        first.next = new Nodelj(2);
        first.next.next = new Nodelj(3);
        assert answer.equals(first, answer);

        answer = nodelj.String2Nodelj("5203");
        first = new Nodelj(5);
        first.next = new Nodelj(2);
        first.next.next = new Nodelj(0);
        first.next.next.next = new Nodelj(3);
        assert answer.equals(first, answer);
    }
}
