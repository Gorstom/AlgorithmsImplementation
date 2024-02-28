//*************wersja iteracyjna*************
pub fn tsp_held_karp(distance: &[Vec<i32>], optimal_route: &mut Vec<usize>) -> i32 {
    let n = distance.len();
    //let mut optimal_distance = i32::MAX;

    // Zainicjuj tabelę zapamiętywania
    let mut memo: Vec<Vec<i32>> = vec![vec![i32::MAX; n]; 1 << n];

    // Przypadek podstawowy
    for i in 1..n {
        memo[1 << i][i] = distance[0][i];
    }

    // Iteruj po wszystkich podzbiorach miast
    for subset_size in 2..=n {
        for subset in combinations(n, subset_size) {
            for k in 0..n {
                if (subset & (1 << k)) != 0 && k != 0 {
                    for m in 0..n {
                        if (subset & (1 << m)) != 0 && m != k {
                            let subset_without_k = subset ^ (1 << k);
                            let mut min_distance = i32::MAX;

                            for p in 0..n {
                                if (subset_without_k & (1 << p)) != 0 && p != k {
                                    let distance_through_k =
                                        memo[subset_without_k][p] + distance[p][k];
                                    min_distance = min_distance.min(distance_through_k);
                                }
                            }

                            memo[subset][k] = min_distance;
                        }
                    }
                }
            }
        }
    }

    // Odtwórz optymalną trasę
    let mut subset = (1 << n) - 1;
    let mut last_city = 0;

    for _ in 1..n {
        let mut next_city = 0;
        let mut min_distance = i32::MAX;

        for k in (1..n).rev() {
            if (subset & (1 << k)) != 0 {
                let distance_through_k = memo[subset][k] + distance[k - 1][last_city];
                if distance_through_k < min_distance {
                    min_distance = distance_through_k;
                    next_city = k;
                }
            }
        }

        optimal_route.push(next_city);
        subset ^= 1 << next_city;
        last_city = next_city;
    }

    // Dodaj miasto początkowe, aby skompletować trasę
    optimal_route.push(0);
    optimal_route.reverse();

    // Zwróć optymalną drogę
    memo[(1 << n) - 1][0]
}

// Funkcja pomocnicza do generowania wszystkich podzbiorów o zadanym rozmiarze
fn combinations(n: usize, k: usize) -> Vec<usize> {
    let mut result = Vec::new();
    let mut current: i32 = (1 << k) - 1;

    while current < 1 << n {
        result.push(current as usize);

        let smallest = current & !(current.wrapping_add(1));
        let ripple = current + smallest;
        let ones = ripple ^ current;
        let mut n_ones = 0;

        while n_ones * smallest != ones {
            n_ones += 1;
        }

        current = ripple | ((1 << n_ones) - 1);
    }

    result
}





//*************wersja rekurencyjna*************
// fn permutationsR(
//     cities: &Vec<Vec<i32>>,
//     start_vertex: usize,
//     current_path: &mut Vec<usize>,
//     visited: &mut Vec<bool>,
//     optimal_route: &mut Vec<usize>,
//     optimal_distance: &mut i32,
// ) {
//     if current_path.len() == cities.len() {
//         // Oblicz odległość bieżącej permutacji
//         let distance = calculate_distanceR(&current_path, &cities);
//
//         // Zaktualizuj optymalną trasę i dystans, jeśli bieżąca permutacja jest lepsza
//         if distance < *optimal_distance {
//             *optimal_distance = distance;
//             optimal_route.clone_from(current_path);
//         }
//     }
//
//     for next_vertex in 0..cities.len() {
//         if !visited[next_vertex] {
//             visited[next_vertex] = true;
//             current_path.push(next_vertex);
//
//             permutationsR(
//                 cities,
//                 start_vertex,
//                 current_path,
//                 visited,
//                 optimal_route,
//                 optimal_distance,
//             );
//
//             visited[next_vertex] = false;
//             current_path.pop();
//         }
//     }
// }
//
// fn calculate_distanceR(path: &[usize], distances: &[Vec<i32>]) -> i32 {
//     let mut distance = 0;
//
//     for i in 0..path.len() - 1 {
//         distance += distances[path[i]][path[i + 1]];
//     }
//
//     // Dodaj odległość powrotną do miasta początkowego
//     distance += distances[path[path.len() - 1]][path[0]];
//
//     distance
// }
//
//
// pub fn tsp_held_karpR(distance: &[Vec<i32>], optimal_route: &mut Vec<usize>) -> i32 {
//     let n = distance.len();
//     let mut optimal_distance = i32::MAX;
//
//     for k in 1..n {
//         let mut current_path = Vec::new();
//         let mut visited = vec![false; n];
//
//         // Dodaj początkowy wierzchołek i oznacz go jako odwiedzony
//         current_path.push(0);
//         visited[0] = true;
//
//         permutationsR(
//             &distance.to_vec(),
//             k,
//             &mut current_path,
//             &mut visited,
//             optimal_route,
//             &mut optimal_distance,
//         );
//     }
//
//     return optimal_distance
// }


