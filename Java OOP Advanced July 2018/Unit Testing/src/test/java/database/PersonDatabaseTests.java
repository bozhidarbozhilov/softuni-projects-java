package database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class PersonDatabaseTests{
    private static final Person[] TEST_ARRAY_WITH_BIGGER_LENGTH = GeneratePeople.generatePeople(18);
    private static final Person[] TEST_ARRAY_WITH_ZERO_LENGTH =  new Person[0];
    private static final Person[] LEGAL_TEST_ARRAY = GeneratePeople.generatePeople(15);
    private static final Person[] TEST_ARRAY_FOR_ADD_REMOVE_FUNCTION = GeneratePeople.generatePeople(16);
    private static final Person TEST_PERSON_FOR_ADD = new Person(15, "Pesho15");
    private static final Person TEST_PERSON_FOR_ADD_WITH_NULL_ID = new Person(null, "Pesho15");
    private static final Person TEST_PERSON_FOR_ADD_WITH_NEGATIVE_ID = new Person(-15, "Pesho15");
    private static final Person TEST_PERSON_FOR_FIND = new Person(5, "Pesho5");

    private Database personTestDataBase;

    @Before
    public void initializeLegalDatabase() throws OperationNotSupportedException {
        this.personTestDataBase = new DatabaseImpl<Person>(LEGAL_TEST_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateDatabaseWithIllegalConstructorWithBiggerSize() throws OperationNotSupportedException {

        this.personTestDataBase = new DatabaseImpl<Person>(TEST_ARRAY_WITH_BIGGER_LENGTH);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateDatabaseWithIllegalConstructorWithZeroLength() throws OperationNotSupportedException {
        this.personTestDataBase = new DatabaseImpl<Person>(TEST_ARRAY_WITH_ZERO_LENGTH);
    }

    @Test
    public void testCreateDatabase(){
        Assert.assertArrayEquals(LEGAL_TEST_ARRAY, this.personTestDataBase.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithNegativeId() throws OperationNotSupportedException {
        this.personTestDataBase.add(TEST_PERSON_FOR_ADD_WITH_NEGATIVE_ID);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElement() throws OperationNotSupportedException {
        this.personTestDataBase.add(TEST_PERSON_FOR_ADD_WITH_NULL_ID);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddElementWithExistingId() throws OperationNotSupportedException {
        this.personTestDataBase.add(TEST_PERSON_FOR_FIND);
    }

    @Test
    public void testValidAddPerson() throws OperationNotSupportedException {
        this.personTestDataBase.add(TEST_PERSON_FOR_ADD);
        Assert.assertArrayEquals(TEST_ARRAY_FOR_ADD_REMOVE_FUNCTION,this.personTestDataBase.getElements());
    }


    @Test
    public void testValidRemoveFunction() throws OperationNotSupportedException {
        this.personTestDataBase = new DatabaseImpl<Person>(TEST_ARRAY_FOR_ADD_REMOVE_FUNCTION);
        this.personTestDataBase.remove();
        Assert.assertArrayEquals(LEGAL_TEST_ARRAY, this.personTestDataBase.getElements());

    }
    @Test(expected = OperationNotSupportedException.class)
    public void testInvalidRemoveFunction() throws OperationNotSupportedException {
        this.personTestDataBase = new DatabaseImpl<Person>(TEST_ARRAY_WITH_ZERO_LENGTH);
        this.personTestDataBase.remove();

    }

    @Test
    public void findByIdFunction() throws OperationNotSupportedException {
        Assert.assertEquals(TEST_PERSON_FOR_FIND,
                (Person)((DatabaseImpl) this.personTestDataBase).findById(TEST_PERSON_FOR_FIND));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdWithWithNullParameter() throws OperationNotSupportedException {
        ((DatabaseImpl) this.personTestDataBase).findById(null);
    }

    @Test
    public void findByNameFunction() throws OperationNotSupportedException {
        Assert.assertEquals(TEST_PERSON_FOR_FIND,
                ((Person)((DatabaseImpl) this.personTestDataBase).findByUserName(TEST_PERSON_FOR_FIND)));
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByNameWithNullParameter() throws OperationNotSupportedException {
        Assert.assertEquals(TEST_PERSON_FOR_FIND,
                ((Person)((DatabaseImpl) this.personTestDataBase).findByUserName(null)));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByNameWithExistingName() throws OperationNotSupportedException {
        Person nonExistingPerson = new Person(19, "Pesho");
        Assert.assertEquals(nonExistingPerson,
                ((Person)((DatabaseImpl) this.personTestDataBase).findByUserName(nonExistingPerson)));
    }
}
