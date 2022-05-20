package main

import (
	"testing"
	"time"
)

func TestExample3(t *testing.T) {
	if true != true {
		t.Fatal("true is not true")
	}
	if false != false {
		t.Fatal("false is not false")
	}
	if 1 == 1 {
		t.fatal("failed")
	}
}

func TestExample4(t *testing.T) {
	time.Sleep(time.Second * 2)

	if true != true {
		t.Fatal("Test with sleep")
	}
}
