n, m = map(int, input().split())
lessons = list(map(int, input().split()))

start, end = max(lessons), sum(lessons)

def func(lessons, start, end):
    res = end
    while start <= end:
        blueray, blueray_size = 1, 0
        mid = (start + end) // 2
        for lesson in lessons:
            if blueray_size + lesson <= mid:
                blueray_size += lesson
            else:
                blueray += 1
                blueray_size = lesson
        if blueray <= m:
            res = mid
            end = mid - 1
        else:
            start = mid + 1
    return res

print(func(lessons, start, end))