function createShallowCopy(array) {
	return [...array];
}

function areEquale(array1, array2) {
	if (array1.length == array2.length) {
		for (let i = 0; i < array1.length; i++) {
			if (array1[i] === array2[i]) {
				return true;
			}
		}
	} else {
		return false;
	}
}

const testArray = [1, 2, 3];
const shallowCoppy = createShallowCopy(testArray);
console.log(areEquale(testArray, shallowCoppy));