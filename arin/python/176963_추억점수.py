# 프로그래머스
# 추억 점수


def solution(name, yearning, photo):
    answer = []
    for people in photo:
        total = 0
        for person in people:
            if person in name:
                i = name.index(person)
                total += yearning[i]
        answer.append(total)
    return answer

solution("", "", "")