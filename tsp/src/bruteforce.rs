pub fn calculate_tour_length(tour: &(Vec<usize>, i32), distances: &[Vec<i32>]) -> i32 {
    let mut length = 0;
    for i in 0..tour.0.len() - 1 {
        length += distances[tour.0[i]][tour.0[i + 1]];
    }
    length += distances[tour.0[tour.0.len() - 1]][tour.0[0]]; // wróć do miasta początkowego
    length
}

fn next_permutation(arr: &mut [usize]) -> bool {
    let mut i = arr.len() - 1;
    while i > 0 && arr[i - 1] >= arr[i] {
        i -= 1;
    }

    if i == 0 {
        return false;
    }

    let mut j = arr.len() - 1;
    while arr[j] <= arr[i - 1] {
        j -= 1;
    }

    arr.swap(i - 1, j);
    arr[i..].reverse();

    true
}
pub(crate) fn brute_force_tsp(distances: &[Vec<i32>]) -> (Vec<usize>, i32) {
    let num_cities = distances.len();

    let mut current_tour: Vec<usize> = (1..num_cities).collect();
    let mut optimal_tour = current_tour.clone(); // na początku trasa optymalana jest równa pierwszej permutacji

    // Zainicjuj optymalną odległość, podając początkową długość trasy
    let mut optimal_distance = calculate_tour_length(&(optimal_tour.clone(), 0), distances);

    // Zacznij od drugiego miasta, ponieważ miasto startowe jest stałe
    while next_permutation(&mut current_tour) {
        let current_distance = calculate_tour_length(&(current_tour.clone(), 0), distances);
        if current_distance < optimal_distance {
            optimal_distance = current_distance;
            optimal_tour.clone_from(&current_tour);
        }
    }

    // dodaj miasto startowe do łącznej trasy
    optimal_tour.insert(0, 0);

    (optimal_tour, optimal_distance)
}


