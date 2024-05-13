use std::{time::Instant, fs::{OpenOptions, File}, io::{self, Write, BufRead}};
use rand::Rng;
mod heldkarp;
mod bruteforce;

use heldkarp::*;
use bruteforce::*;

fn generate_and_write_random_distances(num_cities: usize, max_distance: i32, filename: &str) -> io::Result<()> {
    let mut rng = rand::thread_rng();
    let mut file: File = File::create(filename)?;

    // Write the number of cities in the first line
    writeln!(file, "{}", num_cities)?;

    // Create the distance matrix
    for i in 0..num_cities {
        for j in 0..num_cities {
            let distance:i32 = if i == j {
                0
            } else {
                rng.gen_range(1..=max_distance)
            };
            write!(file, "{} ", distance)?;
        }
        writeln!(file)?;
    }

    Ok(())
}

fn read_distances_from_file(filename: &str) -> io::Result<Vec<Vec<i32>>> {
    let file: File = File::open(filename)?;
    let reader: io::BufReader<File> = io::BufReader::new(file);

    let mut lines: io::Lines<io::BufReader<File>> = reader.lines();
    let num_cities: usize = lines.next().unwrap()?.parse().unwrap();

    let mut distances: Vec<Vec<i32>> = Vec::with_capacity(num_cities);

    for _ in 0..num_cities {
        let line:String = lines.next().unwrap()?;
        let values: Vec<i32> = line
            .split_whitespace()
            .map(|s:&str| s.parse().unwrap())
            .collect();

        distances.push(values);
    }

    Ok(distances)
}

fn main() {
    let mut results_file: File = OpenOptions::new()
        .write(true)
        .append(true)
        .create(true)
        .open("results.txt")
        .expect("Failed to open or create results.txt");

    let mut cities_file: File = OpenOptions::new()
        .write(true)
        .append(true)
        .create(true)
        .open("cities.txt")
        .expect("Failed to open or create cities.txt");

    let max_distance: i32 = 50;
    let num_cities: usize = 10;

     generate_and_write_random_distances(num_cities, max_distance, "cities.txt")
         .expect("Failed to write distances to file");
    let distance_cities: Vec<Vec<i32>> =
        read_distances_from_file("cities.txt").expect("Failed to read distances from file");

    // println!("Distances read from file:");
    // for row in &distance_cities {
    //     for &value in row {
    //         print!("{} ", value);
    //     }
    //     println!();
    // }

    let start_time = Instant::now();
    let mut optimal_route = Vec::new();
    let shortest_path = heldkarp::tsp_held_karp(&distance_cities, &mut optimal_route);
    let elapsed = start_time.elapsed();
    println!("Held-Karp");
    println!("Time elapsed: {} microseconds.", elapsed.as_micros());
    println!("Optimal tour: {:?}", optimal_route);
    println!("Minimal travel cost: {}", shortest_path);
    writeln!(results_file, "{}\t{}\t", num_cities, elapsed.as_micros())
        .expect("Failed to write to results.txt");

    let start_time = Instant::now();
    let optimal_tour = brute_force_tsp(&distance_cities);

    let optimal_length = calculate_tour_length(&optimal_tour, &distance_cities);
    let elapsed = start_time.elapsed();
    println!("Brute Force");
    println!("Time elapsed: {} microseconds.", elapsed.as_micros());
    println!("Optimal Tour: {:?}", optimal_tour);
    println!("Optimal Tour Length: {}", optimal_length);
    writeln!(results_file, "{}\t{}\t", num_cities, elapsed.as_micros())
        .expect("Failed to write to results.txt");
}
