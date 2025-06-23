package main

import "testing"

func TestExample5(t *testing.T) {
	type input struct {
		a int
		b int
	}

	tests := []struct {
		title  string
		input  input
		expect int
	}{
		{
			title: "Test case 1",
			input: input{
				a: 1,
				b: 2,
			},
			expect: 3,
		},
		{
			title: "Test case 2",
			input: input{
				a: 3,
				b: 4,
			},
			expect: 7,
		},
	}

	for _, tt := range tests {
		t.Run(tt.title, func(t *testing.T) {
			actual := tt.input.a + tt.input.b
			if actual != tt.expect {
				t.Errorf("expected %d, got %d", tt.expect, actual)
			}
		})
	}
}
