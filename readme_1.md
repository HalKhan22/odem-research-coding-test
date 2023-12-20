# Trade Analysis Application

This is a solution for analyzing a stream of trades and generating calculated results for each symbol. The application reads an input file named `input.csv` and outputs the results to a file named `output.csv`. The solution is written in [language of choice], includes unit testing, comments, and follows best software practices.

## Input

The input file represents a time series of trades on an exchange, with each row containing values in columns: `<TimeStamp>,<Symbol>,<Quantity>,<Price>`.

### Definitions
- **TimeStamp:** Indicates microseconds since midnight.
- **Symbol:** A 3-character unique identifier for a financial instrument.
- **Quantity:** The amount traded.
- **Price:** The price of the trade for that financial instrument.

### Assumptions
- TimeStamp is always for the same day and won't roll over midnight.
- TimeStamp is increasing or the same as the previous tick (time gap will never be < 0).
- Price is an integer-based currency with no decimal points.
- Price is always > 0.

## Problem

Find the following on a per-symbol basis:
- **Maximum Time Gap:** The amount of time that passes between consecutive trades of a symbol. If only 1 trade is in the file, then the gap is 0.
- **Total Volume Traded:** The sum of the quantity for all trades in a symbol.
- **Max Trade Price:** The maximum price for a trade of a symbol.
- **Weighted Average Price:** Average price per unit traded, not per trade. Result should be truncated to whole numbers.

## Output

The solution produces a file named `output.csv` with the format:
`<Symbol>,<MaxTimeGap>,<Volume>,<WeightedAveragePrice>,<MaxPrice>`

The output is sorted by symbol in ascending order.

## Sample Input

| TimeStamp | Symbol | Quantity | Price |
|-----------|--------|----------|-------|
| 57124702  | aaa    | 13       | 1136  |
| 57124702  | aac    | 20       | 477   |
| 57125641  | aab    | 31       | 907   |
| 57127350  | aab    | 29       | 724   |
| 57127783  | aac    | 21       | 638   |
| 57130489  | aaa    | 18       | 1222  |
| 57130489  | aaa    | 18       | 1222  |
| 57133453  | aab    | 9        | 756   |

### Sample Output:

| Symbol | MaxTimeGap | Volume | WeightedAveragePrice | MaxPrice |
|--------|------------|--------|-----------------------|----------|
| aaa    | 5787       | 40     | 1161                  | 1222     |
| aab    | 6103       | 69     | 810                   | 907      |
| aac    | 3081       | 41     | 559                   | 638      |

Send your source code and output.csv back for evaluation when complete.
Include the amount of time you spent working on the solution.



