namespace rocket_car_dotnet;

public class ExampleTest
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void TestAdd()
    {
        Assert.AreEqual(5, Example.add(2, 3));
    }

    [Test]
    public void TestSub()
    {
        Assert.AreEqual(2, Example.sub(4, 2));
    }

    [Test]
    public void TestMul()
    {
        Assert.AreEqual(10, Example.mul(2, 5));
    }

    [Test]
    public void TestDiv()
    {
        Assert.AreEqual(2, Example.div(10, 5));
    }
}