package example_test

import (
	"fmt"
	"testing"

	"github.com/launchableinc/rocket-car-gotest/example"
)

func TestGreeting(t *testing.T) {
	if "Hello" != example.Greeting() {
		t.Errorf("error invalid value got:%s", example.Greeting())
	}
}

func ExampleGreeting() {
	g := example.Greeting()
	fmt.Println(g)

	// Output:
	// Hello
}

func BenchmarkGreeting(b *testing.B) {
	b.ResetTimer()

	for i := 0; i < b.N; i++ {
		example.Greeting()
	}
}
