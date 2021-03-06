const fs = require('fs');
const input = process.platform === 'linux' ? fs.readFileSync('/dev/stdin').toString().trim() : `F`;

//// 깔끔 : 22 js 문자 인식이 신기해요
const grades = {
  'A+': 4.3,
  A0: 4.0,
  'A-': 3.7,
  'B+': 3.3,
  B0: 3.0,
  'B-': 2.7,
  'C+': 2.3,
  C0: 2.0,
  'C-': 1.7,
  'D+': 1.3,
  D0: 1.0,
  'D-': 0.7,
  F: 0.0,
};

console.log(grades[input].toFixed(1));
