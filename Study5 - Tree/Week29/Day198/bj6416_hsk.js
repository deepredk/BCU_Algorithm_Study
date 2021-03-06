const fs = require('fs');
const stdin = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString().trim()
    : `6 8  5 3  5 2  6 4
5 6  0 0

8 1  7 3  6 2  8 9  7 5
7 4  7 8  7 6  0 0

3 8  6 8  6 4
5 3  5 6  5 2  0 0

1 2  2 3  3 1  3 4
5 6  0 0
-1 -1`
)
  .replace(/\n/gi, '  ')
  .replace(/    /gi, '\n')
  .split('\n');
// 데이터에 트리가 loop트리로 들어오는 경우(4번째 테스트처럼)는 성립하지 않는 코드네요~(wsb의 조언)
// 피드백 올릴 때 바꿔보겠습니다.
//// ->-> 아직 데이터 추가가 된 것이 아니지만 의견 반영을 빨리해주셔서 감사해요!

//// 간선 개수만 세도 된다는 아이디어 좋네요.. 효율적입니다 : 22 간단해요
const getIsTree = (edgeInfoInTree, nodeInfoInTree) => {
  if (edgeInfoInTree.length === nodeInfoInTree.size - 1 || nodeInfoInTree.size === 0) return true;
  else return false;
};

for (let k = 1; k <= stdin.length; k++) {
  let input = stdin[k - 1].split('  ');
  let edgeInfo = input.map((info) => info.split(' ').map((value) => parseInt(value)));

  if (edgeInfo[0][0] < 0 || edgeInfo[0][1] < 0) break;

  let edgeInfoInTree = [];
  let nodeInfoInTree = new Set();
  for (let i = 0; i < edgeInfo.length; i++) {
    const [nodeA, nodeB] = edgeInfo[i];

    if (nodeA === 0 && nodeB === 0) continue;

    edgeInfoInTree.push({
      inEdge: nodeA,
      outEdge: nodeB,
    });
    nodeInfoInTree.add(nodeA);
    nodeInfoInTree.add(nodeB);
  }

  let isTree = getIsTree(edgeInfoInTree, nodeInfoInTree);
  console.log(isTree ? `Case ${k} is a tree.` : `Case ${k} is not a tree.`);
}
