/*
 * @lc app=leetcode id=24 lang=c
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#if 0
#define NULL (void *)0
struct ListNode
{
  int val;
  struct ListNode *next;
};
#endif

struct ListNode *swapPairs(struct ListNode *head)
{
  struct ListNode *emptyHead = malloc(sizeof(struct ListNode));
  if (emptyHead == NULL)
  {
    return NULL;
  }
  emptyHead->val = 0;
  emptyHead->next = head;
  struct ListNode *lastParent = NULL;
  struct ListNode *parent = emptyHead;
  struct ListNode *p = emptyHead;
  for (int i = 0;; i++)
  {
    if ((i - 1) % 2 == 0)
    {
      if (parent == NULL)
      {
        break;
      }
      struct ListNode *p1 = parent->next;
      if (p1 == NULL)
      {
        break;
      }
      struct ListNode *p2 = parent->next->next;
      if (p2 == NULL)
      {
        break;
      }
      struct ListNode *next = parent->next->next->next;
      printf("parent: %d\n", parent->val);
      printf("p1: %d\n", parent->next->val);
      printf("p2: %d\n", parent->next->next->val);
      struct ListNode *temp = p1;
      p1 = p2;
      p2 = temp;
      parent->next = p1;
      p1->next = p2;
      p2->next = next;
      printf("parent: %d\n", parent->val);
      printf("p1: %d\n", parent->next->val);
      printf("p2: %d\n", parent->next->next->val);
      printf("--------------------\n");
      lastParent = parent;
      parent = p2;
    }
    if (p == NULL)
    {
      break;
    }
    p = p->next;
  }
  head = emptyHead->next;
  free(emptyHead);
  return head;
}

// @lc code=end
