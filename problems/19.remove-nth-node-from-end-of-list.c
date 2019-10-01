/*
 * @lc app=leetcode id=19 lang=c
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#define DEBUG 0
#if DEBUG
#define NULL (void *)0
struct ListNode
{
  int val;
  struct ListNode *next;
};
#endif

struct ListNode *removeNthFromEnd(struct ListNode *head, int n)
{
  struct ListNode *p = head;
  struct ListNode *prev = NULL;
  for (int i = 0;; i++)
  {
    if (p == NULL)
    {
      break;
    }
#if DEBUG
    printf("i: %d n: %d\n", i, n);
#endif
    if (i == n)
    {
      prev = head;
    }
    else if (i > n)
    {
      prev = prev->next;
    }
    p = p->next;
  }
  if (prev == NULL)
  {
    struct ListNode *temp = head;
    head = head->next;
    free(temp);
    return head;
  }
#if DEBUG
  printf("prev: %d", prev);
#endif
  struct ListNode *temp = prev->next;
  prev->next = prev->next->next;
  free(temp);
  return head;
}

// @lc code=end
