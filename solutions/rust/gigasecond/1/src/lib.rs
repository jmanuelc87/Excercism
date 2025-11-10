use time::{Duration, PrimitiveDateTime as DateTime};

// Returns a DateTime one billion seconds after start.
pub fn after(start: DateTime) -> DateTime {
    let after = start.checked_add(Duration::seconds(1000000000));
    after.unwrap()
}
