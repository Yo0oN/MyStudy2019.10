"use strict"

console.log(process.argv);

// console.log(process.argv[0]);
// console.log(process.argv[1]);
// console.log(process.argv[2]);
// console.log(process.argv[3]);

for (let value of process.argv) {
    console.log(value);
}

process.argv.forEach((val, index) => {
    console.log(`${index} : ${val}`);
});
