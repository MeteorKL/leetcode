/*
 * @lc app=leetcode id=2 lang=c
 *
 * [2] Add Two Numbers
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

struct ListNode *addTwoNumbers(struct ListNode *l1, struct ListNode *l2)
{
  struct ListNode *result = malloc(sizeof(struct ListNode));
  if (result == NULL)
  {
    return NULL;
  }
  result->next = NULL;
  result->val = 0;
  struct ListNode *p = result;
  struct ListNode *prev = NULL;
  while (l1 != NULL || l2 != NULL)
  {
    if (l1 != NULL)
    {
      p->val += l1->val;
    }
    if (l2 != NULL)
    {
      p->val += l2->val;
    }
    p->next = malloc(sizeof(struct ListNode));
    if (p->next == NULL)
    {
      return NULL;
    }
    p->next->val = 0;
    p->next->next = NULL; // 必须要初始化指针，不然报错：Runtime error: member access within misaligned address 0x000000000031 for type 'struct ListNode', which requires 8 byte alignment
    if (p->val >= 10)
    {
      p->val -= 10;
      p->next->val += 1;
    }
    prev = p;
    p = p->next;
    if (l1 != NULL)
    {
      l1 = l1->next;
    }
    if (l2 != NULL)
    {
      l2 = l2->next;
    }
  }
  if (p->val == 0 && prev != NULL)
  {
    prev->next = NULL;
    free(p);
  }
  return result;
}

// @lc code=end
