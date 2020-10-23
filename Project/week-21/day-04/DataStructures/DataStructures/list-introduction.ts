let listOfNames: string[] = new Array();

console.log(listOfNames.length);

listOfNames.push('William');

console.log(listOfNames.length > 0);

listOfNames.push('John');

listOfNames.push('Amanda');

console.log(listOfNames.length);

console.log(listOfNames[2]);

listOfNames.forEach(name => console.log(name));

listOfNames.forEach((name, index) => console.log(`${index + 1}. ${name}`));

listOfNames.splice(3, 1);

listOfNames.reverse().forEach(name => console.log(name));

listOfNames.splice(0, listOfNames.length);