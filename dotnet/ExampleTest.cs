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
        Assert.AreEqual(7, Example.add(4, 3));
    }

    [Test]
    public void TestSub()
    {
        Assert.AreEqual(2, Example.sub(4, 2));
        Assert.AreEqual(2, Example.sub(4, -2)); // 6 is correct
    }

    [Test]
    public void TestMul()
    {
        Assert.AreEqual(10, Example.mul(2, 5));
        Assert.AreEqual(10, Example.mul(5, 5)); // 25 is correct
    }

    [Test]
    public void TestDiv()
    {
        Assert.AreEqual(2, Example.div(10, 5));
        Assert.AreEqual(0.5, Example.div(5, 10)); // 0 is correct
    }
}