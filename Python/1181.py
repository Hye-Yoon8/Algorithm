# 백준 1181번 - 단어 정렬

N = int(input())

word = []
for i in range(N):
    word.append(input())
word = list(set(word))

word_sort = []
for i in range(len(word)):
    word_sort.append([len(word[i]), word[i]])
word_sort.sort()

for i in range(len(word_sort)):
    print(word_sort[i][1])