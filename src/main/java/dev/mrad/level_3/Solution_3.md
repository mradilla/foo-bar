# Challenge 3 notes
Given this input:

```md
  [0,1,0,0,0,1],  # s0, the initial state, goes to s1 and s5 with equal probability
  [4,0,0,3,2,0],  # s1 can become s0, s3, or s4, but with different probabilities
  [0,0,0,0,0,0],  # s2 is terminal, and unreachable (never observed in practice)
  [0,0,0,0,0,0],  # s3 is terminal
  [0,0,0,0,0,0],  # s4 is terminal
  [0,0,0,0,0,0],  # s5 is terminal
```

## 1. Find the absorbing states

Where the entire row is 0:

```md
2, 3, 4, 5
```


## 2. Build probabilities

Sum row total and divide

Row 0

Total=2, so divide each by 2

```md
0, 1/2, 0, 0, 0, 1/2
```

Row 1

Total=9

```md
4/9, 0, 0, 3/9, 2/9, 0
```

## 3. Find B

Submatrix of probabilities of transitioning between non-absorbing states: 0, 1 → 0, 1

```md
0, 1/2
4/9, 0
```

## 4. Find A

Submatrix of probabilities of transitioning from non-absorbing states to absorbing states:

0, 1 → 2, 3, 4, 5

```md
0, 0, 0, 1/2
0, 3/9, 2/9, 0
```

## 5. Build I

The identity matrix of the absorbing states., same size as B

```md
1, 0
0, 1
```

## 6. Find F

The Fundamental Matrix,

F = (I-B)^⁻1

```md
{9/7, 9/14},
{4/7, 9/7}
```

## 7. Find the solution matrix

Sm = FA

```md
{0, 3/14, 1/7, 9/14}
{0, 3/7, 2/7, 2/7}
```

## 8. Get probabilities

Starting from state 0, so get from row 0

```md
Ps2=0
Ps3=3/14
Ps4=1/7=2/14
Ps5=9/14
```

---
Ref: [Absorbing Markov Chains](https://math.libretexts.org/Bookshelves/Applied_Mathematics/Applied_Finite_Mathematics_(Sekhon_and_Bloom)/10%3A_Markov_Chains/10.04%3A_Absorbing_Markov_Chains)