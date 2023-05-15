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
        Assert.That(Example.add(2, 3), Is.EqualTo(5));
        Assert.That(Example.add(4, 3), Is.EqualTo(7));
    }

    [Test]
    public void TestSub()
    {
        Assert.That(Example.sub(4, 2), Is.EqualTo(2));
        Assert.That(Example.sub(4, -2), Is.EqualTo(2)); // 6 is correct
    }

    [Test]
    public void TestMul()
    {
        Assert.That(Example.mul(2, 5), Is.EqualTo(10));
        Assert.That(Example.mul(5, 5), Is.EqualTo(10)); // 25 is correct
    }

    [Test]
    public void TestDiv()
    {
        Assert.That(Example.div(10, 5), Is.EqualTo(2));
        Assert.That(Example.div(5, 10), Is.EqualTo(0.5)); // 0 is correct
    }
}
