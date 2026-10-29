# Stock Market Price Notification System

## Problem Statement

Design a **Stock Market Price Notification System** using the **Observer Design Pattern** in Java.

The system tracks multiple stocks. Whenever a stock's price changes, all observers subscribed to that stock receive a notification.

Supported observers:

- **Mobile App:** Displays the updated stock price.
- **Price Alert Service:** Generates an alert when the price exceeds a configured threshold.
- **Analytics Service:** Records stock price updates.

The `Stock` class must not depend on concrete observer implementations.

## Functional Requirements

1. Support multiple stocks, such as INFY, TCS, and RELIANCE.
2. Maintain the current price of each stock.
3. Allow observers to subscribe to and unsubscribe from individual stocks.
4. Notify all registered observers when a stock's price changes.
5. Pass the stock symbol and updated price to observers.
6. Allow different observers to implement different reactions.
7. Ensure unsubscribed observers receive no subsequent notifications for that stock.
8. Prevent duplicate subscriptions for the same observer and stock.

## Input Contract

Implement the solution as an in-memory Java application. The `Main` class should demonstrate the system using a predefined sequence of operations. No console input parsing, database, or external API is required.

### Supported operations

| Operation | Parameters | Expected behavior |
|---|---|---|
| `CREATE_STOCK` | `symbol`, `initialPrice` | Creates a stock with its initial price. |
| `SUBSCRIBE` | `symbol`, `observer` | Registers an observer for a stock. |
| `UNSUBSCRIBE` | `symbol`, `observer` | Removes an observer from a stock. |
| `UPDATE_PRICE` | `symbol`, `newPrice` | Updates the stock price and notifies registered observers if the price changes. |

### Input constraints

- Stock symbols must be non-empty strings.
- Initial and updated prices must be greater than zero.
- A stock must exist before it can be subscribed to or updated.
- An observer must implement the `StockObserver` interface.
- Subscribing the same observer instance to the same stock multiple times must not create duplicate notifications.
- Unsubscribing an unregistered observer should be a no-op.
- Updating a stock to its current price must not generate notifications.
- Updating or subscribing to an unknown stock should fail clearly, for example, with an `IllegalArgumentException`.
- Operations execute sequentially on a single thread for this exercise.

## Example Input Scenario

The following sequence represents the required test scenario. It is illustrative pseudocode, not a required text-file format.

```text
CREATE_STOCK INFY 1400
CREATE_STOCK TCS 3500

SUBSCRIBE INFY MobileApp
SUBSCRIBE INFY PriceAlertService(threshold=1500)
SUBSCRIBE INFY AnalyticsService
SUBSCRIBE TCS AnalyticsService

UPDATE_PRICE INFY 1450
UPDATE_PRICE INFY 1550

UNSUBSCRIBE INFY MobileApp

UPDATE_PRICE INFY 1600
UPDATE_PRICE TCS 3550
```

## Output Contract

The implementation must print one notification line per observer callback, in subscription order.

Use the following output formats:

| Observer | Output format |
|---|---|
| Mobile App | `Mobile updated: <symbol> = <price>` |
| Price Alert Service | `ALERT: <symbol> crossed <threshold>` when the price exceeds the threshold |
| Analytics Service | `Analytics recorded: <symbol> = <price>` |

The Price Alert Service receives every price-change notification but prints an alert only when the new price is strictly greater than its threshold.

For this exercise:

- Prices should be printed without unnecessary trailing decimal zeros when they are whole numbers.
- No output is required for subscription or unsubscription operations.
- No output is required when a price is unchanged.
- A price update should notify only observers subscribed to that specific stock.
- Notification order must follow registration order.
- The sample below assumes no observer throws an exception.

## Expected Output

For the example input scenario above, the expected output is:

```text
Mobile updated: INFY = 1450
Analytics recorded: INFY = 1450
Mobile updated: INFY = 1550
ALERT: INFY crossed 1500
Analytics recorded: INFY = 1550
ALERT: INFY crossed 1600
Analytics recorded: INFY = 1600
Analytics recorded: TCS = 3550
```

## Expected Components

| Component | Responsibility |
|---|---|
| `StockObserver` | Defines the notification contract. |
| `Stock` | Maintains price, manages observers, and notifies them. |
| `MobileApp` | Displays updated prices. |
| `PriceAlertService` | Checks the configured price threshold. |
| `AnalyticsService` | Records price updates. |
| `StockMarket` (optional) | Manages stocks by symbol. |
| `Main` | Creates objects and executes the scenario. |

You may introduce a `Subject` interface to abstract subscription and notification behavior.

## Design Constraints

- Use Java and object-oriented design principles.
- Use interfaces for the observer contract.
- The subject must depend on the observer abstraction, not concrete observer classes.
- Do not identify observer types using `if-else` or `instanceof` inside `Stock`.
- Keep stock management, notification, and observer-specific behavior separate.
- Use a collection that preserves subscription order and prevents duplicate registrations.
- Assume synchronous notifications and sequential operations.

## Edge Cases

1. An observer subscribes twice to the same stock.
2. An observer unsubscribes when it is not registered.
3. A stock price is updated to its existing value.
4. A stock has no registered observers.
5. An observer subscribes to multiple stocks.
6. An observer unsubscribes from one stock but remains subscribed to another.
7. An unknown stock is referenced during an update or subscription.
8. An invalid price is provided.
9. An observer throws an exception during notification.

## Acceptance Criteria

The solution is complete when:

- Multiple stocks maintain independent prices and subscriber lists.
- Observers can subscribe and unsubscribe independently for each stock.
- Each valid price change notifies the currently registered observers exactly once.
- Observers react according to their own implementations.
- Unsubscribed observers receive no subsequent notifications.
- An unchanged price generates no notifications.
- The output matches the specified formats and ordering.
- The `Stock` class does not depend on concrete observer classes.

## Interview Follow-up Questions

1. How would you prevent duplicate subscriptions?
2. What should happen if an observer throws an exception?
3. How would you make the implementation thread-safe?
4. How would you support different thresholds for different users?
5. What are the differences between the Push and Pull models?
6. How would you scale notifications to millions of subscribers?
7. When would you use a message broker instead of an in-memory Observer implementation?

## Learning Objective

Understand how the Observer Design Pattern establishes a one-to-many dependency between objects, enabling automatic notifications while keeping the subject loosely coupled from its observers.

**Recommended approach:** Design the class diagram first, explain the responsibilities, implement the solution, and verify that the output matches the contract.
