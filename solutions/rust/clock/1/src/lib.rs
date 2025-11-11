use std::fmt::Display;

#[derive(Debug, PartialEq, Eq)]
pub struct Clock {
    h: i32,
    m: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        let total_minutes = ((hours * 60 + minutes) % 1440 + 1440) % 1440;
        Self {
            h: total_minutes / 60,
            m: total_minutes % 60,
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        let left_hours = minutes / 60;
        let left_minutes = minutes % 60;

        let mut hours = (self.h + left_hours + ((self.m + left_minutes) / 60)) % 24;
        let mut minutes = (self.m + left_minutes) % 60;

        if minutes < 0 {
            hours = ((hours - 1) % 24 + 24) % 24;
            minutes = 60 + minutes;
        }

        Self {
            h: hours,
            m: minutes,
        }
    }
}

impl Display for Clock {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{:02}:{:02}", self.h, self.m)
    }
}
