const createPerson = (name, surname, age, weight) => {
	return {
		name,
		surname,
		age,
		weight
	}
};

let person = createPerson('Martin', 'Fucik', 30, 102);
console.log(person.name);
console.log(person.surname);
console.log(person.age);
console.log(person.weight);

const changeProperty = (object, propertyName, value) => {
	object[propertyName] = value;
}

changeProperty(person, 'name', 'Ales');
console.log(person.name);

const deleteProperty = (object, propertyName) => {
	delete object[propertyName];
}

deleteProperty(person, 'age');
console.log(person);

const compareObjects = (obj1, obj2) => {
	const keys1 = Object.keys(obj1);
	const keys2 = Object.keys(obj2);

	if (keys1.length !== keys2.length) {
		return false;
	}
	
	for (let i = 0; i < keys1.length; i++) {
		if (keys1[i] !== keys2[i]) {
			return false;
		}
	}

	return true;
}

let person2 = createPerson('Ales', 'Fucik', 30, 102);
deleteProperty(person2, 'age');

console.log(compareObjects(person, person2));